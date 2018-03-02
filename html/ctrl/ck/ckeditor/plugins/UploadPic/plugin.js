(function () {
 CKEDITOR.plugins.add('UploadPic',
{    init: function(editor)
    {
        var pluginName = 'UploadPic';
        CKEDITOR.dialog.add(pluginName, this.path + 'dialogs/UploadPic.js');
        editor.addCommand(pluginName, new CKEDITOR.dialogCommand(pluginName));
        editor.ui.addButton('UploadPic',
            {
                label: '图片上传',
                command: pluginName,
				icon: CKEDITOR.plugins.getPath('UploadPic') + 'uploadpic.png',
				click:function(e){
						var apid=e.name;
						if($("#subdiv1")[0]){
				  		    $("#subdiv1")[0].remove()
			  		     }
						var userc=$("#userLogin").val();
						var mydiv = document.createElement("div");
					 	mydiv.setAttribute("id","subdiv1")
					 	mydiv.setAttribute("style","display:none")
			  		     var subFom = document.createElement("form"); 
			  		      	  subFom.setAttribute("method","POST")
			  		      	  subFom.setAttribute("enctype","MULTIPART/FORM-DATA")
			  		      	  subFom.setAttribute("action","/upload/c?uid="+userc+"&CKEditorFuncNum="+apid)
			  		      	  subFom.setAttribute("target","myiframe")
			  		      var subIut = document.createElement("input"); 
			 				  subIut.setAttribute("type","file")
			  		      	  subIut.setAttribute("name","uploadimg")
			  		      	  subIut.setAttribute("id","uploadimg")
			  		      	  
			  		      var subIut1 = document.createElement("input"); 
			 				  subIut1.setAttribute("type","submit")
			  		      	  subIut1.setAttribute("id","mysumit")
			  		      	  subIut1.setAttribute("value","上传")
			  		      	 // subIut1.setAttribute("onclick","CKEDITOR.dialog.getCurrent().hide()")
			  		      	  
			  		      	  
			  		      var subIifr = document.createElement("iframe"); 
			  		      	  subIifr.setAttribute("name","myiframe")
			  		      	  subIifr.setAttribute("id","myiframe")
			  		      subFom.appendChild(subIut); 
			 				subFom.appendChild(subIut1);
			 				
			 				mydiv.appendChild(subFom)
			 				mydiv.appendChild(subIifr)
			 				
			  		 	document.body.appendChild(mydiv)
			  		 	$("#uploadimg").trigger("click")
				}
            });
    }
}); 
 
 
 
 
 
 
 
 $("body").on("change","#uploadimg", function () { 
	 var files = this.files;
	 if (files && files.length && (/^image\/\w+$/.test(files[0].type)) ) {
		$("#mysumit").trigger("click");
	}
 });
 
 
 
 
 

 })();