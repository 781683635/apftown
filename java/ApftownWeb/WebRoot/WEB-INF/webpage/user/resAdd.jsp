<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="../comm/tag.jsp" %>

<% menuType = "sys1";  %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>新闻发布-亚太金融(基金)小镇_基金注册_注册基金_基金小镇_金融小镇</title>
    <meta name="keywords" content="apftown,亚太,金融,基金,证券,基金小镇,金融小镇,特色小镇,亚太金融（基金）小镇" />
    <meta name="description" content="三亚•亚太金融（基金)小镇是海南省也是中国首个国际金融小镇。小镇地处亚龙海棠之中心，传承海上丝绸之路千年底蕴，引领中国“走出去”时代浪潮，是中国进入亚太的桥头堡。小镇响应国家“一带一路”发展战略，抢抓“人民币国际化”历史机遇，积极促进“亚太自贸区”的建设，联合海内外金融力量，构建五个产学研一体化平台。" />
	
	<meta charset="utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <%@ include file="../comm/css.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/comm/sky-forms.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user/user.css">
    <%@ include file="../comm/ck.jsp" %>
    <%@ include file="../comm/cutImg.jsp" %>
  
  </head>
  
  <body>
  	<div class="wrap">
	 	<%@ include file="../comm/header.jsp" %>
		
		<div class="container clear">
			<div class="clear">
				<img class="pull-left" src="<%=path %>/img/user/user03.png" alt="亚太金融（基金）小镇"> 
				<span class="pull-left f-18 pt-20 pl-10">用户中心</span>
				<span class="pull-right hov-primary pt-20">
					<a class="hov-primary" href="<%=path %>/index.do">首页</a>
					<i class=" icon-angle-right pl-5 pr-5"></i><a class="hov-primary" href="<%=path %>/user/index.do">用户中心</a>
					<i class=" icon-angle-right pl-5 pr-5"></i>新闻发布
				</span>
			</div>
			<div class="row pt-10">
				<%@ include file="./menu.jsp"%>
				<div class="col-sm-10 bor-light pt-5">
					<c:if test="${sessionScope.UserEntity.getUserName() != 'news' }">
						<div class="text-center mt-20"> 
							<h2 class="">抱歉，您不是管理员</h2>
						</div>
					</c:if>
					<c:if test="${sessionScope.UserEntity.getUserName() == 'news' }">
						<div class="row mb-10">
							<h3 class="f-14 gradient-gray clear">
								<span class="pull-left pd-10 line-h-20 f-16">发布新闻</span>
							</h3>
						</div>
						<div>
							<form id="newsaddForm" method="post" class="sky-form">
					            <input name="#no" value="res r,res_lg rl,res_prop_ln rpl" type="hidden">
					            <input name="#fk" value="rl.res_id=r.id,rpl.res_id=r.id" type="hidden">
					            <input type="hidden" name="r.cat_id" value="200000">
					            <input type="hidden" name="r.user_id" value="@sUid@">
					            <input type="hidden" name="r.status" value="0">
					            <input type="hidden" name="r.update_time" value="@tIMe@">
							    <input type="hidden" id="rid" name="r.id" value="${newsList.id }">
							    <input type="hidden" name="rl.lg" value="${lg }">
							    <input type="hidden" name="r.lang" value="${lang }">
					             <!--  <input name="#fl" value="rc.content=notnull" type="hidden">  -->
								<div class="mb-15 mt-20 maimglst" >
								<!--  aratio="0" 为0,图片是随便伸展,aratio="1"为1,为图片固定大小。  -->
								    <div class="text-center mb-15 resImg" aratio="16/9" title="resImg" >
										<a href="javscript:;" class="upload uploadbg" toggle="modal" data-target="#myModal" onclick="modal_show()">
											<img src="${empty newsList.img ? '' : newsList.img}" alt="亚太金融（基金）小镇" class="uploadimg" name="rImg">
											<input type="hidden" name="r.img" value="${newsList.img }"/>
										</a>
							       </div>
								</div>		
								<input type="hidden" name="rpl.code" id="rpCode" value="${newsList.code }">
								<!-- 分类 -->
								<div class="f-13 mt-10 clear">
									<div class="col-xs-3 col-sm-2 col-md-1 col-lg-1 text-right pull-left pr-0 line-h-20">
										<label class="inline-block ipt-label"><em class="col-red">*&nbsp;</em>分类:</label>
									</div>
									<div class="col-xs-9 col-sm-10 col-md-11 pd-0 ">
										<div class="col-xs-12 col-sm-4 mb-10 pl-0 pr-5">
											<div class="sel sel-ck" name="code">
												<input type="hidden"  class="cback1" id="selectCode" value="${fn:substring(newsList.code, 0,1) }">
												<div class="s-input radius0"><span>请选择一级分类</span><i class="icon-caret-down"></i></div>
												<ul class="opt opt-ck line-h-20" id="code" onchange="setResProp(this.value,'city')">
												</ul>
											</div>
										</div>
										<div class="col-xs-12 col-sm-4 mb-10 pl-0 pr-5">
											<div class="sel sel-ck" name="code2">
												<input type="hidden"  class="cback2" id="selectCode2" value="${newsList.code }">
												<div class="s-input radius0"><span>请选择二级分类</span><i class="icon-caret-down"></i></div>
												<ul class="opt opt-ck" id="code2" onchange="setResProp(this.value,'county')">
												</ul>
											</div>
										</div>
										<div class="col-xs-12 col-sm-4 mb-10 pl-0 pr-5">
											<div class="sel sel-ck" name="code3">
												<input type="hidden" class="cback3" id="selectCode3">
												<div class="s-input radius0"><span>请选择三级分类</span><i class="icon-caret-down"></i></div>
												<ul class="opt opt-ck" id="code3">
												</ul>
											</div>
										</div>
									</div>	
								</div>
								<!-- 标题 -->	      
								<div class="f-13 mb-15 mt-15 clear">
									<div class="col-xs-3 col-sm-2 col-md-1 text-right pull-left pd-0 line-h-20">
										<label class="ipt-label inline-block"><em class="col-red">*&nbsp;</em>标题:</label>
									</div>
									<div class="col-xs-9 col-sm-10 col-md-11 pl-0 pr-5">
										<input type="text" name="rl.title" value="${newsList.title }" class="ipt-text radius0" >
									</div>
								</div>
								<!-- 副标题 -->
								<div class="f-13 mb-15 mt-15 clear">
									<div class="col-xs-3 col-sm-2 col-md-1 text-right pull-left pd-0 line-h-20">
										<label class="ipt-label inline-block"><em class="col-red">*&nbsp;</em>副标题:</label>
									</div>
									<div class="col-xs-9 col-sm-10 col-md-11 pl-0 pr-5">
										<input type="text" name="rl.title2" value="${newsList.title2 }" class="ipt-text radius0" >
									</div>
								</div> 
								<!-- 来源 -->
								<div class="f-13 mb-15 mt-15 clear">
									<div class="col-xs-3 col-sm-2 col-md-1 text-right pull-left pd-0 line-h-20">
										<label class="ipt-label inline-block"><em class="col-red">*&nbsp;</em>来源:</label>
									</div>
									<div class="col-xs-9 col-sm-10 col-md-11 pl-0 pr-5">
										<input type="text" name="rl.vfrom" value="${newsList.vfrom }" class="ipt-text radius0" >
									</div>
								</div>
								<!-- 作者 -->
								<div class="f-13 mb-15 mt-15 clear">
									<div class="col-xs-3 col-sm-2 col-md-1 text-right pull-left pd-0 line-h-20">
										<label class="ipt-label inline-block"><em class="col-red">*&nbsp;</em>作者:</label>
									</div>
									<div class="col-xs-9 col-sm-10 col-md-11 pl-0 pr-5">
										<input type="text" name="rl.author" value="${newsList.author }"
											class="ipt-text radius0">
									</div>
								</div>
								<!-- 关键词 -->
								<div class="f-13 mb-15 mt-15 clear">
									<div class="col-xs-3 col-sm-2 col-md-1 text-right pull-left pd-0 line-h-20">
										<label class="ipt-label inline-block"><em class="col-red">*&nbsp;</em>关键词:</label>
									</div>
									<div class="col-xs-9 col-sm-10 col-md-11 pl-0 pr-5">
										<input type="text" name="r.keyword" value="${newsList.keyword }" class="ipt-text radius0" >
									</div>
								</div>
								<!-- 描述 -->
								<div class="f-13 mb-15 mt-15 clear">
									<div class="col-xs-3 col-sm-2 col-md-1 text-right pull-left pd-0 line-h-20">
										<label class="ipt-label inline-block"><em class="col-red">*&nbsp;</em>描述:</label>
									</div>
									<div class="col-xs-9 col-sm-10 col-md-11 pl-0 pr-5">
										<textarea class="textarea textarea-numberbar radius0" name="rl.vdesc" cols="30" rows="10">${newsList.vdesc }</textarea>
									</div>
								</div>
								<!-- 富文本框 -->
								<div class="f-13 mb-15 mt-15 clear">
									<div class="col-xs-3 col-sm-2 col-md-1 text-right pull-left pd-0 line-h-20">
										<label class="ipt-label inline-block"><em class="col-red">*&nbsp;</em>内容：</label>
									</div>
									<div class="col-xs-9 col-sm-10 col-md-11 pl-0 pr-5">
										<div class=" fade in active" id="profile1">
											<textarea id="content1" cols="80" name="rl.vtext" rows="10" value="" >${newsList.vtext }</textarea>
											<script type="text/javascript">
											    var editor1 = null;
										        editor1 = CKEDITOR.replace( 'content1', {
										            customConfig:'config.js',
										            height:200,
										        });
										        CKFinder.setupCKEditor( editor1, './ckfinder2.3.1/' ); 
											</script>
										</div>
									</div>
								</div>
								<button id="optres" type="submit" class="btn radius0 btn-primary btn-normal pull-right ">提交</button>
							</form>
						</div>
					</c:if>
				</div>
			</div>
		</div>
   		
	</div>
        <div class="show">
			<div class="modal-dialog">	
			    <div class="modal-content clear" id="myModal" >
				      <div class="modal-body clear">
					            <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" style="padding:0px;">
						                <div class="img-container">
						                    <img src="" alt="点击下面选择文件按钮进行选择文件！">
						                    <div class="img-type" style="display:none"></div>
						                </div>
					            </div>
				        </div>
			        <div class="modal-footer2 clear">
			            <div class=" col-xs-12">
			            	<div class="row clear mt-10 mb-5">
			        		<div class="col-sm-7 clear">
		                    <button class="btn btn-operate btn-margin-t3 bbttnn operate" data-method="zoom" data-option="0.1" type="button" title="Zoom In">
			                    <span class="docs-tooltip inline-block" data-toggle="tooltip">
			                        <span class="icon icon-zoom-in"></span>
			                    </span>
		                    </button>
		                    <button class="btn btn-operate btn-margin-t3 bbttnn operate" data-method="zoom" data-option="-0.1" type="button" title="Zoom Out">
			                    <span class="docs-tooltip inline-block" data-toggle="tooltip">
			                        <span class="icon icon-zoom-out"></span>
			                    </span>
		                    </button>
		                    <button class="btn btn-operate btn-margin-t3 bbttnn operate" data-method="rotate" data-option="-90" type="button" title="Rotate Left">
			                    <span class="docs-tooltip inline-block" data-toggle="tooltip">
			                        <span class="icon icon-rotate-left"></span>
			                    </span>
		                    </button>
		                    <button class="btn btn-operate btn-margin-t3 bbttnn operate" data-method="rotate" data-option="90" type="button" title="Rotate Right">
			                    <span class="docs-tooltip inline-block" data-toggle="tooltip">
			                        <span class="icon icon-rotate-right"></span>
			                    </span>
		                    </button>
		                    <button class="btn btn-operate btn-margin-t3 bbttnn operate" data-method="reset" type="button" title="Reset">
			                    <span class="docs-tooltip inline-block" data-toggle="tooltip">
			                        <span class="icon icon-refresh "></span>
			                    </span>
		                    </button>
			                </div>
				            <div class="col-sm-5 upload-fr clear">
			                    <label style="overflow:hidden;" class="btn btn-upload btn-margin-r3 bbttnn pull-left" for="inputImage" title="Upload image file">
			                        <input class="sr-only" id="inputImage" type="file" name="file" >
			                        <span class="btn-operate docs-tooltip chose" data-toggle="tooltip">
			                            选择文件
			                        </span>
			                    </label>  
			                    <label class="btn btn-operate btn-upload btn-margin-r3 bbttnn pull-left" data-method="getCroppedCanvas" type="button">
			                        <span class="span-upload docs-tooltip inline-block" data-toggle="tooltip">
			                            确认上传
			                        </span>
			                    </label>
			                    <label class="btn btn-operate btn-margin-r3 bbttnn inline-block pull-left" type="button">
			                        <span class="span-upload docs-tooltip inline-block" data-dismiss="modal" id="cancle" >
			                            取消
			                        </span>
			                    </label>
				                </div>
			            	</div>
			            </div>
			            
			            <div class="modal fade docs-cropped" id="getCroppedCanvasModal" aria-hidden="true" aria-labelledby="getCroppedCanvasTitle" role="dialog" tabindex="-1">
			            </div>
			        </div>
			    </div> 	
			</div>
		</div>

	<%@ include file="../comm/js.jsp" %>
   	<script type="text/javascript" src="${pageContext.request.contextPath }/js/comm/jquery.validate.min.js"></script>
   	<script type="text/javascript" src="${pageContext.request.contextPath }/js/user/resAdd.js"></script>
	<%@ include file="../comm/footer.jsp"%>
    
    
  </body>
</html>
