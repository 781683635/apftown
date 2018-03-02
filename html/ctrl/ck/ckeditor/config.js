
/**
 * @license Copyright (c) 2003-2015, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	var _language =$("#sfLg").val();
	if (_language=="en"){
		config.language = 'en';
	}else{
		config.language = 'zh-cn';
	}
	config.skin = 'moonocolor';
	
	config.uploadUrl='/upload/c?command=QuickUpload&type=Files&responseType=json';
	config.filebrowserUploadUrl  = "/upload/c?command=QuickUpload&type=Files&responseType=json";  
	config.filebrowserImageUploadUrl = '/upload/c?command=QuickUpload&type=Images&responseType=json';  
    config.filebrowserFlashUploadUrl = '/upload/c?command=QuickUpload&type=Flash&responseType=json';
    
    if(/android|iphone|symbianos|windows phone|ipad|ipod|blackberry/i.test(navigator.userAgent)){
    	config.toolbar = [
    	                  ['Bold','Italic'],
    	                  ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
    	                  ['NumberedList','BulletedList'],
    	                  ['UploadPic','Table',"-",'Format','Font','FontSize'],
    	                  ];
    	config.extraPlugins= 'UploadPic';
    }else{
    	config.toolbar = [
    	                  ['Cut','Copy','Paste','PasteText', 'SpellChecker'],
    	                  ['SelectAll','RemoveFormat'],
    	                  ['Bold','Italic','Underline','Strike'],
    	                  ['NumberedList','BulletedList','-','Outdent','Indent' ],
    	                  [ 'Link', 'Unlink'],
    	                  ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','HorizontalRule'],['TextColor','BGColor'],
    	                  ['UploadPic',"BrowserPic",'Table',"-",'Format','Font','FontSize'],
    	                  ];
    	config.extraPlugins= 'UploadPic,BrowserPic';
    }
    
    
	
	//config.font_names = '宋体/宋体;黑体/黑体;仿宋/仿宋_GB2312;楷体/楷体_GB2312;隶书/隶书;幼圆/幼圆;微软雅黑/微软雅黑;'+ config.font_names ;
    config.font_names = '微软雅黑/微软雅黑;';
	config.uiColor = '#f9f9f9';
	config.dialog_backgroundCoverColor = 'rgb(255, 255, 255)';
	config.removeDialogTabs = 'image:advanced;image:Link';
};


