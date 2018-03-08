<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<input type="hidden" value="${newsInfo.id }" id="resId">				
<!-- <div class="row clear mt-20"> -->
	<div class="comment-out bg-white mt-20">
		<div class="line-h-20 clear">
			<span class="pull-left pd-5 gra-pri col-white">参与评论</span>
			<span class="pull-left pd-5 ml-10 col-999">文明上网理性发言，请遵守《三亚亚太金融(基金)小镇评论服务协议》</span>
			<span class="pull-right pt-5"><span class="col-pri pd-5" id="commentCnt">${fn:length(commlst) }</span>条评论</span>
		</div>
		<div class="ipt bor-ccc">
			<textarea style="height:80px; border:none;resize:none;" class="full-w pd-10 comment-edit" placeholder="您想说点什么...." name="" id="" cols="30" rows="10"></textarea>
			<div class="bg-gray clear line-h-15">
				<span class="pull-right pd-5 gra-pri col-white f-14 mg-5 cur-p line-h-15 publish" onclick="pubCmt(this)">发表评论</span>
				<%
					if(null != user){
				%>
					<span class="col-pri pull-right mt-5 mb-5 mr-20 pr-20 pd-5"><%=user.getRegName() %></span>
					<img class="img-25 pull-right full-rounded mg-5" src="<%=user.getUserImg() %>" alt="亚太金融（基金）小镇">
					
				<% }else{ %>
					<span class="pr-10 pull-right line-h-15 pd-5 mt-5">您还没有登录，请<a class="col-pri pl-5" href="<%=path %>/loginui.do?targetUrl=<%=path %>/news/info.do?rid=${resInfo.id }">登录</a></span>
				<% } %>
			</div>
		</div>
		<div class="comment bor-ccc bor-t-none bg-white">
			<div id="commentlist">
				<c:forEach var="cmt" items="${commlst }">
					<div class="com-list pt-5 comment${fn:length(cmt.class_id)}"  pid="${cmt.id }">
						<p class="pd-5">
							<img class="img-25 full-rounded" src="<c:if test="${not empty cmt.user_img}">${cmt.user_img}</c:if><c:if test="${empty cmt.user_img}">./img/comm/noupload.jpg</c:if>" alt="亚太金融（基金）小镇">
							<span class="col-pri pl-5 pr-5">${cmt.user_name }</span>
							<span class="col-999" name="tt">
								${cmt.tt }
							</span>
						</p>
						<p class="pt-5 pb-5 pr-5 pl-10 ml-20 line-h-20 newline">${cmt.comment }</p>
						<div class="repl-out ml-20 pl-10">
							<p class="clear bor-b-l pr-5">
								<c:if test="${ssUser.id eq cmt.user_id }">
									<span class="pull-right pd-5 col-pri cur-p" onclick="commentdel(this)">删除</span>
								</c:if>
								<span class="pull-right pd-5 col-pri cur-p repl" onclick="commentRepl(this)">回复</span>
								<span class="pull-right pd-5 col-pri laud cur-p" onclick="commentlike(this)">支持（<span class="col-pri">${cmt.user_likes }</span>）</span>
							</p>
							<div class="bor-light text-out overflow-h ipt dis-n mr-5 mb-5">
								<textarea name="" class="full-w ipt pd-10" style="height:60px;border:none;resize:none;" id="" cols="30" rows="10"></textarea>
								<p class="clear bg-gray">
									<span class="pull-right pd-5 col-white bg-primary cur-p" onclick="pubCmt(this)">&nbsp;回复&nbsp;</span>
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
<!-- </div> -->

<script type="text/javascript" src="<%=path %>/js/comm/comment.js"></script>

<script type="text/html" id="commentDemo">
	{{# for ( var i in d.commlst) { }}
		
		<div class="com-list comment{{d.commlst[i].class_id.length}}" pid="{{d.commlst[i].id}}">
			<p class="pd-5">
				<img class="img-25 full-rounded" src="{{isNull(d.commlst[i].user_img)?'./img/comm/noupload.jpg':d.commlst[i].user_img}}" alt="亚太金融（基金）小镇">
				<span class="col-pri pl-5 pr-5">{{d.commlst[i].user_name}}</span>
				<span class="col-999" name="tt">{{d.commlst[i].tt}}</span>
			</p>
			<p class="pt-5 pb-5 pr-5 pl-10 ml-20 line-h-20 newline">{{d.commlst[i].comment}}</p>
			<div class="repl-out ml-20 pl-10">
				<p class="clear bor-b-l pr-5">
					<span class="pull-right pd-5 col-pri cur-p" onclick="commentdel(this)">删除</span>
					<span class="pull-right pd-5 col-pri cur-p repl" onclick="commentRepl(this)">回复</span>
					<span class="pull-right pd-5 col-pri laud cur-p" onclick="commentlike(this)">支持（<span class="col-pri">0</span>）</span>
				</p>
				<div class="bor-light text-out overflow-h ipt dis-n mr-5 mb-5">
					<textarea name="" class="full-w ipt pd-10" style="height:60px;border:none;resize:none;" cols="30" rows="10"></textarea>
					<p class="clear bg-gray">
						<span class="pull-right pd-5 col-white bg-primary cur-p" onclick="pubCmt(this)">&nbsp;回复&nbsp;</span>
					</p>
				</div>
			</div>
		</div>

	{{# } }}
</script>

