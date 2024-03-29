/**
 * 
 */

$cameraimgcontainer = "";
$(function() {
	var w = 320, h = 240;
	var pos = 0, ctx = null, saveCB, image = [];

	var canvas = document.createElement("canvas");
	canvas.setAttribute('width', w);
	canvas.setAttribute('height', h);

	console.log(canvas.toDataURL);
	if (canvas.toDataURL) {
		ctx = canvas.getContext("2d");
		image = ctx.getImageData(0, 0, w, h);
		saveCB = function(data) {
			var col = data.split(";");
			var img = image;
			for (var i = 0; i < w; i++) {
				var tmp = parseInt(col[i]);
				img.data[pos + 0] = (tmp >> 16) & 0xff;
				img.data[pos + 1] = (tmp >> 8) & 0xff;
				img.data[pos + 2] = tmp & 0xff;
				img.data[pos + 3] = 0xff;
				pos += 4;
			}

			if (pos >= 4 * w * h) {
				ctx.putImageData(img, 0, 0);
				/*
				 * $.post("servlet/CatD", {type: "data", image:
				 * canvas.toDataURL("image/png")}, function(msg){
				 * console.log("===="+eval(msg)); pos = 0; $("#img").attr("src",
				 * msg+""); });
				 */
				$.ajax({
							type : "post",
							url : "servlet/CatD?t=" + new Date().getTime(),
							data : {
								type : "pixel",
								image : canvas.toDataURL("image/png")
							},
							dataType : "html",
							success : function(data) {
								console.log("====" + data);
								pos = 0;
								$("#img").attr("src", "");
								$("#img").attr("src", data);

								$cameraimgcontainer
										.html("<img src='"
												+ data
												+ "' style='width:100%;height:100%;margin-top:0;'/>");
								swal({
									title : "拍照成功",
									timer : 2000,
									confirmButtonColor : "#fa8229"
								});
								setTimeout(function() {
									$(".finger-mark.camera button.cancel")
											.click();
								}, 2000);
							}
						});
			}
		};
	} else {
		saveCB = function(data) {
			image.push(data);
			pos += 4 * w;
			if (pos >= 4 * w * h) {
				/*
				 * $.post("servlet/CatD", {type: "pixel", image:
				 * image.join('|')}, function(msg){
				 * console.log("+++++"+eval(msg)); pos = 0;
				 * $("#img").attr("src", msg+""); });
				 */
				$.ajax({
							type : "post",
							url : "servlet/CatD",
							data : {
								type : "pixel",
								image : image.join('|')
							},
							dataType : "json",
							success : function(data) {
								console.log("+++++" + eval(msg));
								pos = 0;
								$("#img").attr("src", msg + "");
								$cameraimgcontainer
										.html("<img src='"
												+ data
												+ "' style='width:100%;height:100%;margin-top:0;'/>");
								swal({
									title : "拍照成功",
									timer : 2000,
									confirmButtonColor : "#fa8229"
								});
								setTimeout(function() {
									$(".finger-mark.camera button.cancel")
											.click();
								}, 2000);
							}
						});
			}
		};
	}

	$("#webcam").webcam({
		width : w,
		height : h,
		mode : "callback",
		swffile : "js/jscam_canvas_only.swf",
		onTick: function(remain) {
	       /* if (0 == remain) {
	            jQuery("#status").text("Cheese!");
	        } else {
	            jQuery("#status").text(remain + " seconds remaining...");
	        }*/
	    },
		onSave : saveCB,
		onCapture : function() {
			webcam.save();
		},
		debug : function(type, string) {
			console.log(type + ": " + string);
		}
		/*,onLoad: function () {
		        var cams = webcam.getCameraList();
		        for(var i in cams) {
		            jQuery("#cams").append("<li>" + cams[i] + "</li>");
		        }
		    }*/
	});
});

// 拍照
function savePhoto() {
	webcam.capture();
}

/*
 * $(function () { var image = new Array(); var w = 320, h = 240; var pos = 0;
 * $("#webcam").webcam({ width: w, height: h, mode: "callback", swffile:
 * "${ctxStatic }/jquery-plugin/jscam_canvas_only.swf", // canvas only doesn't
 * implement a jpeg encoder, so the file is much smaller
 * 
 * onTick: function (remain) { if (0 == remain) {
 * jQuery("#status").text("Cheese!"); } else { jQuery("#status").text(remain + "
 * seconds remaining..."); } },
 * 
 * onSave: function (data) { // Work with the picture. Picture-data is encoded
 * as an array of arrays... Not really nice, though =/ image.push(data); pos +=
 * 4 * w; if (pos == 4 * w * h) { $.post("${ctx}/common/webcam/uploadPhoto", {w:
 * w, h: h, image: image.join('|')}, function (msg) { pos = 0; image = new
 * Array(); $("#img").attr("src", "${ctx}/"+msg); }); } },
 * 
 * onCapture: function () { webcam.save(); // Show a flash for company },
 * 
 * debug: function (type, string) { // Write debug information to console.log()
 * or a div, ... },
 * 
 * onLoad: function () { // Page load var cams = webcam.getCameraList(); for
 * (var i in cams) { jQuery("#cams").append("<li>" + cams[i] + "</li>"); } }
 * }); });
 */

