﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿var BuddyConnect = $Class({
	_elBottomBox : null,
	_elSubView : null,
	_elTabArea : null,
	_oList : null,
	_elContent : null,
	_htVisbleEl : {
		'listArea' : null,
		'byMe' : null,
		'toMe' : null
	},
	_sSelectedGroupId :'',
	sLoginId : '',
	sBlogId : '',
	sListType : '',
	sAuthCode : '',
	sWidgetSeq :'',
	sBlogUserNo : '',
	sBlogNo : '',
	bIsAritcleWidget : false,
	sTomeListType : '',
	oTidOverFade : null,
	oTidOutFade : null,
	
	_aTabClass : ['tab1on','tab2on'],
	_MSG : {
		'NEWARTICLE' : '새글보기',
		'NEWARTICLE_MORE' : '새글 더 보기',
		'CLOSEVISIBLEBUDDY' : '비공개 하시겠습니까?',
		'NOBODY' : {
			'GROUP' : {
				'ARTICLE' : '선택하신 그룹에 등록된 <br> 이웃 새글이 없습니다.',
				'BUDDY' : '선택하신 그룹에 등록된 <br> 이웃이 없습니다.'
			}
		}
	},
	htListType : {
		'L' : 'basic',
		'T' : 'thumb',
		'D' : 'detail',
		'P' : 'article'
	},



	$init : function(op){
		var elWidget = op.elWidget;
		this.sLoginId = op.sLoginId;
		this.sBlogId = op.sBlogId;
		this.sAuthCode = op.sAuthCode;
		this.sWidgetSeq = op.sWidgetSeq;
		this.sBlogNo = op.sBlogNo;
		this.sBlogUserNo = op.sBlogUserNo;
		this.bIsAritcleWidget = op.bIsAritcleWidget;
		this.sTomeListType = this.bIsAritcleWidget ? this.htListType["D"] : this.htListType[op.sWidgetType];
		this._elContent = $$.getSingle("> div.wrap > div.content",elWidget);
		this._elTabArea = $$.getSingle("ul.tab",elWidget);
		this._elSubView = $$.getSingle("div.sub_view",this._elContent);
		this._elBottomBox = $$.getSingle("div.bottom_box",elWidget);
		this.setListType(this.htListType[op.sWidgetType]);
		this._initVisibleEl();
		this._oList = new BuddyConnect.List(this);
		this._setEvt();
	},

	getListType : function(sListType){
		return this.htListType[sListType];
	},

	getIsAritcleWidget : function(){
		return this.bIsAritcleWidget;
	},

	setListType : function(sListType){
		this.sListType = sListType;
		if(this._htVisbleEl['listArea'] instanceof $Element) this._htVisbleEl['listArea'].hide();
		this._htVisbleEl['listArea'] = $Element($$.getSingle(BuddyConnect.htVisibleElement[this.sListType],this._elContent));
	},

	setAsyncURL : function(htTable){
		if(typeof htTable != "undefined"){
			for(var i in BuddyConnect.METADATA){
				BuddyConnect.METADATA[i] = htTable[i];
			}
		}
	},

	getSubView : function(){
		return this._elSubView;
	},

	getListArea : function(){
		return this._htVisbleEl.listArea;
	},

	_initVisibleEl : function(){
		this._htVisbleEl = {
			'listArea' : null,
			'byMe' : $Element($$.getSingle(BuddyConnect.htVisibleElement['common']['byMe'],this._elContent)),
			'toMe' : $Element($$.getSingle(BuddyConnect.htVisibleElement['common']['toMe'],this._elContent)),
			'noBody' : {
				'byMe' : $Element($('noBody_byMe')),
				'toMe' : $Element($('noBody_toMe')),
				'article' : $Element($('noBody_article')),
				'group' : $Element($('noBody_group'))
			}
		};
	},

	_setEvt : function(){
		$Fn(this._onClickClickCr, this).attach(document, 'click');
		$Fn(this._onClickTab,this).attach(this._elTabArea,'click');
		$Fn(this._onClickContent,this).attach(this._elContent,'click');
		/*
		var elSpan = $$.getSingle("span", this._elBottomBox);
		$Fn(this._onOverBottom,this).attach(elSpan,'mouseover');
		$Fn(this._onOutBottom,this).attach(elSpan,'mouseout');
		*/
	},
	/*
	_onOverBottom: function(we){	
		var welSpan = $Element(we.element);
		welSpan.opacity(0);
		var func = function(){
			if(welSpan.opacity() == 1) {
				clearTimeout(this.oTidOverFade);
				return;
			}else{
				welSpan.opacity(welSpan.opacity()+0.2);
			}
			if(this.oTidOverFade) clearTimeout(this.oTidOverFade);
			this.oTidOverFade = setTimeout(func,50);	
		};
		if(this.oTidOutFade) clearTimeout(this.oTidOutFade);
		this.oTidOverFade = setTimeout(func,50);	
	},
	
	_onOutBottom: function(we){
		var welSpan = $Element(we.element);
		welSpan.opacity(1);
		var func = function(){
			if(welSpan.opacity() == 0) {
				clearTimeout(this.oTidOutFade);
				return;
			}else{
				welSpan.opacity(welSpan.opacity()-0.2);
			}
			if(this.oTidOutFade) clearTimeout(this.oTidOutFade);
			this.oTidOutFade = setTimeout(func,50);	
		};
		if(this.oTidOverFade) clearTimeout(this.oTidOverFade);
		this.oTidOutFade = setTimeout(func,50);	
	},
	*/

	_onClickTab : function(e){
		e.stopDefault();
		var el = e.element;
		if(el.nodeType != 1 || el.tagName.toLowerCase() != "li") el = el.parentNode;
		var sClassName = el.className;
		var wEParentNode = $Element(el.parentNode);

		if((sClassName == "col1" && wEParentNode.hasClass("tab1on")) || (sClassName == "col2" && wEParentNode.hasClass("tab2on"))) return false;
		else this.setPageNo(1);

		switch(sClassName){
			case "col1" :
				this._activeTab("first");
				this._listContent(this._getAsyncListURL(this._getPageNo()));
				break;

			case "col2" :
				this._activeTab("second");
				this._listContent(this._getAsyncListURL(this._getPageNo()));
				break;

			default :
			break;
		};
		this._hideBuddyGroup();
		return false;
	},

	_displayList : function(){
		this._hideNoBody();
		if(this.isFirstTab()) this._displayByMeList();
		else this._displayToMeList();
		$Element(this.getSubView()).show();
	},

	_hideNoBody : function(){
		this._htVisbleEl["noBody"]["byMe"].hide();
		this._htVisbleEl["noBody"]["toMe"].hide();
		this._htVisbleEl["noBody"]["article"].hide();
		this._htVisbleEl["noBody"]["group"].hide();
	},

	_displayNoBodyList : function(sListType){
		var bIsFIrstTab = this.isFirstTab();
		var bHasBuddy = false;
		this._htVisbleEl["byMe"].hide();
		this._htVisbleEl["toMe"].hide();
		this._htVisbleEl["listArea"].hide();
		this._htVisbleEl["noBody"]["group"].hide();
		$Element(this.getSubView()).hide();
		if(this.bIsAritcleWidget) this._hideArticleList();			

		if(sListType == "article"){
			if(this._sSelectedGroupId != null && this._sSelectedGroupId != ''){
				this._htVisbleEl["noBody"]["group"].show();
				bHasBuddy = parseInt($$.getSingle(" div.sub_select  p.amount  span.co_num",this._elContent).innerHTML,10) > 0
				if(bHasBuddy) this._htVisbleEl["noBody"]["group"].html(this._MSG["NOBODY"]["GROUP"]["ARTICLE"]);	
				else this._htVisbleEl["noBody"]["group"].html(this._MSG["NOBODY"]["GROUP"]["BUDDY"]);
								
				this._htVisbleEl["byMe"].show();
				this._htVisbleEl["noBody"]["article"].hide();
			}else{
				this._htVisbleEl["noBody"]["article"].show();
				$Element($$.getSingle(BuddyConnect.htVisibleElement[this.sTomeListType],this._elContent)).hide();
				this._htVisbleEl["noBody"]["byMe"].hide();
				this._htVisbleEl["noBody"]["toMe"].hide();
			}
		}else{
			this._htVisbleEl["noBody"]["article"].hide();
			if(bIsFIrstTab){
				if(this._sSelectedGroupId != null && this._sSelectedGroupId != ''){
					this._htVisbleEl["noBody"]["group"].show();
					this._htVisbleEl["noBody"]["group"].html(this._MSG["NOBODY"]["GROUP"]["BUDDY"]);
					this._htVisbleEl["byMe"].show();
				}else{
					this._htVisbleEl["noBody"]["byMe"].show();
					this._htVisbleEl["noBody"]["toMe"].hide();
				}
			}else{
				this._htVisbleEl["noBody"]["byMe"].hide();
				this._htVisbleEl["noBody"]["toMe"].show();
				this._htVisbleEl["toMe"].show();

				var wElNobodyOwner = $Element($$.getSingle(" div.no_inbuddy_v2",this._htVisbleEl["noBody"]["toMe"].$value()));
				var wElNobodyOther = $Element($$.getSingle(" div.no_inbuddy",this._htVisbleEl["noBody"]["toMe"].$value()));																		
				bHasBuddy = !$Element($$.getSingle(" div.buddy_cnt > p > span.numset > span",this._elContent)).hasClass("n0");				
				var elTemp = null;
				if(this.sLoginId == this.sBlogId) {					
					wElNobodyOwner.show();
					wElNobodyOther.hide();
					elTemp = wElNobodyOwner.$value();										
				}else{								
					wElNobodyOther.show();
					wElNobodyOwner.hide();
					elTemp = wElNobodyOther.$value();									
				}
				var welNobdyNotHave = $Element($$.getSingle("> ._notHaveBuddy",elTemp));
				var welNobdyNotOpen = $Element($$.getSingle("> ._notOpenBuddy",elTemp));
			
				if(bHasBuddy) {
					welNobdyNotOpen.show();
					welNobdyNotHave.hide();
				}else{
					welNobdyNotOpen.hide();
					welNobdyNotHave.show();
				}				
			}
		}
	},

	_displayByMeList : function(){
		if(this.bIsAritcleWidget) {
			$Element($$.getSingle(BuddyConnect.htVisibleElement[this.sTomeListType],this._elContent)).hide();
		}
		this._htVisbleEl["toMe"].hide();
		this._htVisbleEl["byMe"].show();
		this._htVisbleEl["listArea"].show();
	},

	_displayToMeList : function(){
		
		if(this.bIsAritcleWidget) this._hideArticleList();
		
		this._htVisbleEl["byMe"].hide();
		this._htVisbleEl["toMe"].show();
		this._htVisbleEl["listArea"].show();
	},
	
	_hideArticleList : function(){
		$Element($$.getSingle(BuddyConnect.htVisibleElement["article"],this._elContent)).hide();
	},

	/**
	 * clickcr 버블링 처리
	 * @param {Object} we
	 */
	_onClickClickCr : function(we){
		var aParam, elTarget;
		var el = we.element;
		var elBtn = this.getElement(el, "a");
		if(el.className.indexOf("_clickcr")> -1){
			aParam = this.getParam(el.className);
			elTarget = el;
		}else if(elBtn && elBtn.className.indexOf("_clickcr")> -1){
			aParam = this.getParam(elBtn.className);
			elTarget = elBtn;
		}
		if(aParam){
			clickcr(elTarget, aParam[0], '', aParam[1]||'', we.$value());
		}
	},

	_onClickContent : function(e){
		var el = e.element;
		var sTagName = el.tagName.toLowerCase();
		if(sTagName == "img"){
			el = el.parentNode;
			sTagName = el.tagName.toLowerCase();
		}
		var aClassName = el.className.split(" ");
		if(sTagName != "input" && aClassName[aClassName.length-1] == "_returnFalse") e.stopDefault();
		var sActionName = aClassName[0];
		if(sTagName == "a"){
			switch(sActionName){
				case "select_ui" :
						this._toggleBuddyGroup();
					break;

				case "next" :
					this._listContent(this._getAsyncListURL(this._getPageNo(sActionName)));
					clickcr(el, "wbm.page", '', this._getPageNo(sActionName), e.$value());
					break;

				case "pre" :
					this._listContent(this._getAsyncListURL(this._getPageNo(sActionName)));
					clickcr(el, "wbm.page", '', this._getPageNo(sActionName), e.$value());
					break;
				case "_delete" :
					this._deleteBuddy(el);
					break;

				default : break;
			};
		}else if(sTagName == "li"){
			this.setPageNo(1);
			this._onSelectBuddyGroups(el);
		};

		return true;
	},

	_deleteBuddy : function(el){
		if(confirm(this._MSG.CLOSEVISIBLEBUDDY)) window.location.href = BuddyConnect.METADATA.URL.DELETEBUDDY +'?blogId='+this.sBlogId+'&blogNo='+this.sBlogNo+'&buddyBlogNo='+this.sBlogUserNo+'&widgetSeq='+this.sWidgetSeq;

	},

	_onSelectBuddyGroups : function(elSelected){
	if(!$$.getSingle("!> ul !> div.buddy_list",elSelected)) return;

		var sGroupName = elSelected.innerHTML;
		var aParam = this.getParam(elSelected.className);
		this._sSelectedGroupId = aParam[0];

		var fnCallback = function(){
			var aElChild = $$("> li",$$.getSingle("> ul",$('buddy_list')));
			for(var i =0,len = aElChild.length;i<len;i++){
				if(aElChild[i] == elSelected) $Element(aElChild[i]).addClass("selected");
				else $Element(aElChild[i]).removeClass("selected");
			}
			$$.getSingle(" div.sub_select > a.select_ui",this._elContent).innerHTML = sGroupName;
		};
		this._listContent(this._getAsyncListURL(this._getPageNo()),fnCallback);
		this._hideBuddyGroup();
	},

	getParam : function(sClassName){
		if(sClassName){
			var rxParameter = /_param\((.*)\)/;
			var aMatch = sClassName.match(rxParameter);
			if(aMatch && aMatch[0] && aMatch[1]){
				return aMatch[1].split("|");
			}
		}
		return null;
	},

	/**
	 * 엘리먼트 기준으로 상위 엘리먼트를 찾는 메소드
	 * @param {HTMLElement} el 기준 엘리먼트
	 * @param {String} sTagName 찾고자 하는 태그 네임
	 * @param {String} sClassName 찾고자 하는 클래스명
	 * @return {HTMLElement} 찾은 엘리먼트
	 */
	getElement : function(el, sTagName, sClassName){
		if(typeof sClassName == "undefined"){
			if (el.tagName.toLowerCase() == sTagName) {
				return el;
			}
			else {
				return $$.getSingle("!" + sTagName, el);
			}
		}else{
			if (el.tagName.toLowerCase() == sTagName && $Element(el).hasClass(sClassName)) {
				return el;
			}
			else {
				return $$.getSingle("!" + sTagName + "." + sClassName, el);
			}
		}
	},

	_getGroupId :function(){
		return this._sSelectedGroupId;
	},

	setPageNo : function(nPageNo){
		this._oList.setPageNo(nPageNo);
	},

	_getPageNo : function(sType){
		var nPageNo = this._oList.getCurNo();
		if(sType == "next"){
			nPageNo++;
		}else if(sType =="pre"){
			nPageNo--;
		}

		return nPageNo;
	},

	isFirstTab : function(){
		return $Element(this._elTabArea).hasClass(this._aTabClass[0]);
	},

	_getAsyncListURL : function(nPageNo){
		var sURL = "";
		if(this.isFirstTab()) sURL = BuddyConnect.METADATA.URL.BUDDYLISTBYME;
		else sURL = BuddyConnect.METADATA.URL.BUDDYLISTTOME;

		return sURL + "?blogId="+this.sBlogId+"&groupId="+this._getGroupId()+"&currentPage="+nPageNo+"&authCode="+this.sAuthCode+"&widgetSeq="+this.sWidgetSeq;
	},

	_listContent : function(sURL,fCallback){
		var oAjax = new $Ajax(sURL,{
			'onload' : $Fn(function(res){
				var oRes = res.json();
				if(oRes.isSuccess){
					var htResult = oRes.result;
					var sListType = this.getListType(htResult.listType);
					this.setListType(sListType);
					this.upDateBuddyCnt(htResult.buddyCount);
					var htListInfo = (sListType == "article") ? htResult.posts : htResult.buddies;
					if(htListInfo.list.length > 0){
						this._oList.list(htListInfo,htResult.listType);
						this._displayList();
					}else{
						this._displayNoBodyList(sListType);
					}
					
					this.upDateBuddyGroup(htResult.buddyGroups);
					if(fCallback && typeof fCallback == 'function') fCallback();
				}
			},this).bind()
		});
		oAjax.request();
	},

	upDateBuddyGroup : function(htBuddyGroup){
		this._sSelectedGroupId = htBuddyGroup.selectedGroupId;
		var elBuddyGroup = $$.getSingle(" div.buddy_list > ul",this._elContent);
		var aBuddyGroup = htBuddyGroup.list;
		elBuddyGroup.innerHTML = this._getBuddyGroup(aBuddyGroup);
	},

	_getBuddyGroup : function(aList){
		var aRe = [];
		var oTpl = new $Template(BuddyConnect.template.buddyGroup);
		aList.unshift({
			'selected' : 'null',
			'groupName' : '전체 이웃',
			'groupId' : 'null',
			'openyn' : true
		})

		for(var i =0,len=aList.length;i<len;i++){
			aRe.push(oTpl.process({
				'selected' : aList[i]["groupId"] == this._sSelectedGroupId ? "selected" : "",
				'groupName': aList[i]["groupName"],
				'groupId' : aList[i]["groupId"],
				'openyn' : aList[i]["openyn"] == true ? "none" :"inline"
			}));
		}
		return aRe.join("");
	},

	upDateBuddyCnt : function(nBuddyCnt){
		if(this.isFirstTab()) this._updateToMeBuddyCnt(nBuddyCnt);
		else this._updateByMeBuddyCnt(nBuddyCnt);
	},

	_showArticleMoreTxt : function(el){
		el.innerHTML = this._MSG.NEWARTICLE_MORE;
	},

	_toggleBuddyGroup : function(){
		var wBuddyList = $Element($$.getSingle(" div.buddy_list",this._elContent));
		if(wBuddyList.visible()) this._hideBuddyGroup();
		else wBuddyList.show();
	},

	_hideBuddyGroup : function(){
		$Element($$.getSingle(" div.buddy_list",this._elContent)).hide();
	},

	_activeTab : function(sSeq){
		var wElTabArea = $Element(this._elTabArea);
		var welContent = $Element(this._elContent);
		var sClassName = "tab2";
		var nActive = 0;
		var nNonAtice = 1;
		if(sSeq != "first"){
			nActive = 1;
			nNonAtice = 0;
			welContent.addClass(sClassName);
		}else{
			welContent.removeClass(sClassName);
		}
		wElTabArea.removeClass(this._aTabClass[nNonAtice]);
		wElTabArea.addClass(this._aTabClass[nActive]);
	},

	_updateToMeBuddyCnt : function(nBuddyCnt){
		var elBuddyCnt = $$.getSingle(" div.sub_select  p.amount  span.co_num",this._elContent);
		if(nBuddyCnt >= 0 && elBuddyCnt) elBuddyCnt.innerHTML = nBuddyCnt;
	},

	_updateByMeBuddyCnt : function(nBuddyCnt){
		var aHTMLBuddyCnt = [];
		var aBuddyCnt = String(nBuddyCnt).split("");
		var elBuddyCnt = $$.getSingle(" div.buddy_cnt > p > span.numset",this._elContent);
		var oTpl = $Template(BuddyConnect.template.buddyCnt.num);
		for(var i = 0,len = aBuddyCnt.length;i<len;i++){
			aHTMLBuddyCnt.push(oTpl.process({'num' : aBuddyCnt[i]}));
		}
		$$.getSingle(" div.buddy_cnt > p > strong",this._elContent).innerHTML = nBuddyCnt;
		elBuddyCnt.innerHTML = aHTMLBuddyCnt.join("") +BuddyConnect.template.buddyCnt.dssc;
	},

	getTabType : function(){
		return this.isFirstTab() ? "byMe" : "toMe";
	},

	getLoginId : function(){
		return this.sLoginId;
	}
});

BuddyConnect.METADATA = {
	'IMGPATH' : "http://blogimgs.naver.com/buddyconnect/widget/",
	'THUMBIMGPATH' :"http://blogthumb2.naver.net",
	'URL' : {
		'DELETEBUDDY' : '/connect/FollowerVisibilityClose.nhn',
		'BUDDYLISTTOME' : '/connect/WidgetAddedMeAsBuddyViewAsync.nhn',
		'BUDDYLISTBYME' : '/connect/WidgetViewAsync.nhn'
	}
};

BuddyConnect.template = {
	buddyCnt : {
		'num' : '<span class="n{=num}"></span>',
		'dssc' : '<span class="desc1"><img alt="명이" src="'+BuddyConnect.METADATA.IMGPATH+'b.gif" width="18" height="11"></span><span class="desc2"><img alt="이 블로그를 구독중입니다" src="'+BuddyConnect.METADATA.IMGPATH+'b.gif" width="111" height="11"></span>'
	},
	buddyGroup : '<li class="_param({=groupId}) {=selected}">{=groupName} <img width="9" height="11" alt="비공개" style="display:{=openyn}" src="http://blogimgs.naver.com/nblog/admin/buddy/ico_lock.gif"/></li>'
};

BuddyConnect.htVisibleElement = {
	'common': {
		'byMe' : "div.sub_select",
		'toMe' : "div.buddy_cnt"
	},
	'basic' : "> ul.txt_list",
	'detail' : "> ul.thumb_list2",
	'thumb' : "> ul.thumb_list",
	'article' : "> ul.article_list"
};

BuddyConnect.List = $Class({
	_oPaging : null,
	_upObj : null,
	$init : function(obj){
		this._upObj = obj;
		this._oPaging = new BuddyConnect.List.Paging(this);
	},

	list : function(htListInfo,sListType){
		this._upObj.getListArea().$value().innerHTML = this._getListHTML(htListInfo.list,this._upObj.getListType(sListType), ((htListInfo.currentPage-1) * htListInfo.countPerPage));
		var nTotalPageNo = Math.floor(htListInfo.totalCount / htListInfo.countPerPage);
		var nMod = htListInfo.totalCount % htListInfo.countPerPage > 0 ? 1 : 0;
		nTotalPageNo = nTotalPageNo+nMod == 0 ? 1 : nTotalPageNo+nMod;
		this._oPaging.goPage(htListInfo.currentPage, nTotalPageNo);
	},

	_getListHTML : function(aList,sListType, nDiffRank){
		var aHTMLList = [];
		var sTabType = this._getTabType();
		var oTpl = $Template(BuddyConnect.List.template[sListType][sTabType]);

		if(sListType == "article"){
			for(var i =0,len = aList.length;i<len;i++){
				aHTMLList.push(oTpl.process({
					'linkUrl' : aList[i]["linkUrl"],
					'commentCnt' : aList[i]["commentCnt"],
					'hasCmt' : parseInt(aList[i]["commentCnt"],10) > 0 ? "" : "none",
					'content' : aList[i]["content"],
					'lastModified' : aList[i]["lastModified"],
					'blogName' : aList[i]["blogName"],
					'title' : aList[i]["title"],
					"RANK" : i + nDiffRank + 1
				}));
			};
		}else if(sListType == "thumb"){
			for(var i =0,len = aList.length;i<len;i++){
				aHTMLList.push(oTpl.process({
					'buddyURL' : aList[i]["linkUrl"],
					'buddyImg' : aList[i]["imgUrl"],
					'hasNewPost' : aList[i]["hasNewPost"] == true ? "" : "none",
					'neighborNickName' : aList[i]["neighborNickName"] != "" ? aList[i]["neighborNickName"] : aList[i]["blogName"],
					'blogId' : aList[i]["blogId"],
					'blogName' : aList[i]["blogName"],
					'isMe' : aList[i]["blogId"] == this._getLoginId() ? "" : "none",
					"RANK" : i + nDiffRank + 1
				}));
			};
		}else{
			for(var i =0,len = aList.length;i<len;i++){
				aHTMLList.push(oTpl.process({
					'buddyURL' : aList[i]["linkUrl"],
					'buddyImg' : aList[i]["imgUrl"],
					'hasNewPost' : aList[i]["hasNewPost"] == true ? "" : "none",
					'neighborNickName' : aList[i]["neighborNickName"] != "" ? aList[i]["neighborNickName"] : "",
					'hasNickName' : aList[i]["neighborNickName"] != "" ? "": "none",
					'hasNewPost' : aList[i]["hasNewPost"] == true ? "" : "none",					
					'blogId' : aList[i]["blogId"],
					'blogName' : aList[i]["blogName"],
					'isMe' : aList[i]["blogId"] == this._getLoginId() ? "" : "none",
					'nickNameTag' : aList[i]["neighborNickName"] != "" ? "a": "span",
					"RANK" : i + nDiffRank + 1
				}));
			};
		}

		return aHTMLList.join("");
	},

	_getTabType : function(){
		return this._upObj.getTabType();
	},

	_getLoginId : function(){
		return this._upObj.getLoginId();
	},

	getSubView : function(){
		return this._upObj.getSubView();
	},

	getCurNo : function(){
		return this._oPaging.getCurNo();
	},

	setPageNo : function(nPageNo){
		this._oPaging.setCurNo(nPageNo);
	}
});

BuddyConnect.List.template = {
	'basic' : {
		'byMe' : '<li><div class="buddy_info"><a style="display:{=hasNickName};" target="_blank" href="{=buddyURL}" class="buddy_name _clickcr _param(wmy.list|{=RANK})" >{=neighborNickName}</a><span style="display:{=hasNickName};" class="bar"> | </span><a class="blog_name _clickcr _param(wmy.list|{=RANK})" target="_blank" href="{=buddyURL}">{=blogName}</a> <img height="11" width="13" class="up" alt="update" src="http://blogimgs.naver.com/buddyconnect/widget/b.gif" style="display:{=hasNewPost};"></div></li>',
		'toMe' : '<li><div class="buddy_info"><a class="_delete _returnFalse" style="display:{=isMe};" href="/connect/FollowerVisibilityClose.nhn?blogId=qa1tc03&amp;blogNo=44020771&amp;buddyBlogNo=43903703&amp;widgetSeq=2"><img height="11" width="11" class="del" alt="delete" src="http://blogimgs.naver.com/buddyconnect/widget/b.gif"></a> <a style="display:{=hasNickName};" target="_blank" href="{=buddyURL}" class="buddy_name _clickcr _param(wme.list|{=RANK})" >{=neighborNickName}</a><span style="display:{=hasNickName};" class="bar"> | </span><a class="blog_name _clickcr _param(wme.list|{=RANK})" target="_blank" href="{=buddyURL}">{=blogName}</a> <img height="11" width="13" class="up" alt="update" src="http://blogimgs.naver.com/buddyconnect/widget/b.gif" style="display:{=hasNewPost};"></div></li>'
	},
	'thumb' : {
		'byMe' : '<li><div class="buddy_img"><a href="{=buddyURL}" target="_blank" class="_clickcr _param(wmy.list|{=RANK})"><img height="40" width="40" alt="" onerror="this.onerror=null; this.src=\'http://blogimgs.naver.com/nblog/comment/login_basic.gif\';" src="'+BuddyConnect.METADATA.THUMBIMGPATH+'{=buddyImg}"/><span class="co_box"></span></a><img height="11" width="13" class="up" style="display:{=hasNewPost};"alt="update" src="'+BuddyConnect.METADATA.IMGPATH+'b.gif"/></div><a target="_blank" class="buddy_name _clickcr _param(wmy.list|{=RANK})" href="{=buddyURL}">{=neighborNickName}</a></li>',
		'toMe' : '<li><div class="buddy_img"><a href="{=buddyURL}" target="_blank" class="_clickcr _param(wme.list|{=RANK})"><img height="40" width="40" alt="" onerror="this.onerror=null; this.src=\'http://blogimgs.naver.com/nblog/comment/login_basic.gif\';" src="'+BuddyConnect.METADATA.THUMBIMGPATH+'{=buddyImg}"/><span class="co_box"></span></a><a href="#" class="_delete _returnFalse" style="display:{=isMe};"><img class="del" width="11" height="11" title="delete" alt="delete" src="'+BuddyConnect.METADATA.IMGPATH+'b.gif"/></a><img height="11" width="13" class="up" style="display:{=hasNewPost};"alt="update" src="'+BuddyConnect.METADATA.IMGPATH+'b.gif"/></div><a target="_blank" class="buddy_name _clickcr _param(wme.list|{=RANK})" href="{=buddyURL}">{=neighborNickName}</a></li>'
	},
	'detail' : {
		'byMe' : '<li><div class="buddy_img"><a href="{=buddyURL}" target="_blank" class="_clickcr _param(wmy.list|{=RANK})"><img height="40" width="40" alt="" onerror="this.onerror=null; this.src=\'http://blogimgs.naver.com/nblog/comment/login_basic.gif\';" src="'+BuddyConnect.METADATA.THUMBIMGPATH+'{=buddyImg}"/><span class="co_box"></span></a><img height="11" width="13" class="up" style="display:{=hasNewPost}; alt="update" src="'+BuddyConnect.METADATA.IMGPATH+'b.gif"/></div><div class="buddy_info"><{=nickNameTag}  target="_blank" class="buddy_name _clickcr _param(wmy.list|{=RANK})" href="{=buddyURL}">{=neighborNickName}</{=nickNameTag}><span style="display:none;" class="bar"> | </span><a target="_blank" class="blog_name _clickcr _param(wmy.list|{=RANK})" href="{=buddyURL}">{=blogName}</a></div></li>',
		'toMe' : '<li><div class="buddy_img"><a href="{=buddyURL}" target="_blank" class="_clickcr _param(wme.list|{=RANK})"><img height="40" width="40" alt="" onerror="this.onerror=null; this.src=\'http://blogimgs.naver.com/nblog/comment/login_basic.gif\';" src="'+BuddyConnect.METADATA.THUMBIMGPATH+'{=buddyImg}"/><span class="co_box"></span></a><a href="#" class="_delete _returnFalse" style="display:{=isMe};"><img class="del" width="11" height="11" title="delete" alt="delete" src="'+BuddyConnect.METADATA.IMGPATH+'b.gif"/></a><img height="11" width="13" class="up" style="display:{=hasNewPost}; alt="update" src="'+BuddyConnect.METADATA.IMGPATH+'b.gif"/></div><div class="buddy_info"><{=nickNameTag} target="_blank" class="buddy_name _clickcr _param(wme.list|{=RANK})" href="{=buddyURL}">{=neighborNickName}</{=nickNameTag}><span style="display:none;"  class="bar"> | </span><a target="_blank" class="blog_name _clickcr _param(wme.list|{=RANK})" href="{=buddyURL}">{=blogName}</a></div></li>'
	},
	'article' : {
		'byMe' : '<li><dl><dt><a target="_blank" class="article_title _clickcr _param(wmy.list|{=RANK})" href="{=linkUrl}">{=title}</a> <span style="display:{=hasCmt};" class="comment_cnt">[{=commentCnt}]</span></dt><dd class="pub_desc"><a target="_blank" class="article_desc _clickcr _param(wmy.list|{=RANK})" href="{=linkUrl}">{=content}</a></dd><dd class="pub_info"><span class="pub_date">{=lastModified}</span> <a target="_blank" class="blog_name _clickcr _param(wmy.list|{=RANK})" href="{=linkUrl}">{=blogName}</a></dd></dl></li>'
	}
};

BuddyConnect.List.Paging = $Class({
	_upObj : null,
	_nCurNo : 1,
	elCurPage : null,
	$init : function(obj){
		this._upObj = obj;
		this.elCurPage = $$.getSingle("> p.paging > span.paging_now",this._upObj.getSubView());
	},

	setCurNo : function(nCurNo){
		this._nCurNo = nCurNo;
		this.elCurPage.innerHTML = nCurNo;
	},

	getCurNo : function(){
		return this._nCurNo;
	},

	goPage : function(nCurNo,nTotalNo){
		this.setCurNo(nCurNo);
		this._updateTotalCnt(nTotalNo);

		if(nCurNo == 1) this._disablePreBtn();
		else this._enablePreBtn();
		if(nTotalNo != nCurNo) this._enableNextBtn();
		else this._disableNextBtn();
	},

	_updateTotalCnt : function(nTotal){
		var elPagingTotal = $$.getSingle("> p.paging > span.paging_all",this._upObj.getSubView());
		elPagingTotal.innerHTML = "/ " + nTotal;
	},

	_enablePreBtn : function(){
		var elPreBtn = $$.getSingle("> p.paging > .pre_n",this._upObj.getSubView());
		if(!elPreBtn) return;
		var elParent = elPreBtn.parentNode;
		var elNewPreBtn = $(BuddyConnect.List.Paging.template.pre);
		elParent.insertBefore(elNewPreBtn,elPreBtn);
		elParent.removeChild(elPreBtn);
	},

	_disablePreBtn : function(){
		var elPreBtn = $$.getSingle("> p.paging > .pre",this._upObj.getSubView());
		if(!elPreBtn) return;
		var elParent = elPreBtn.parentNode;
		var elNewPreBtn = $(BuddyConnect.List.Paging.template.first);
		elParent.insertBefore(elNewPreBtn,elPreBtn);
		elParent.removeChild(elPreBtn);
	},

	_enableNextBtn : function(){
		var elNextBtn = $$.getSingle("> p.paging > .next_n",this._upObj.getSubView());
		if(!elNextBtn) return;
		var elParent = elNextBtn.parentNode;
		var elNewNextBtn = $(BuddyConnect.List.Paging.template.next);
		elParent.insertBefore(elNewNextBtn,elNextBtn);
		elParent.removeChild(elNextBtn);
	},

	_disableNextBtn : function(){
		var elNextBtn = $$.getSingle("> p.paging > .next",this._upObj.getSubView());
		if(!elNextBtn) return;
		var elParent = elNextBtn.parentNode;
		var elNewNextBtn = $(BuddyConnect.List.Paging.template.last);
		elParent.insertBefore(elNewNextBtn,elNextBtn);
		elParent.removeChild(elNextBtn);
	}
});
BuddyConnect.List.Paging.template = {
	'first' : '<a class="pre_n _returnFalse"><span>처음</span></a>',
	'last' : '<a class="next_n _returnFalse"><span>끝</span></a>',
	'pre' : '<a href="#" class="pre _returnFalse" href="#"><span>이전</span></a>',
	'next' : '<a href="#" class="next _returnFalse"><span>다음</span></a>'
};
/**
 * Utility Class
 * @author niceilm(AU2)
 * @name Utility
 * @class
 * @description : Blog Common Library
 * @dependecy JINDO2
 * @date : 2010.02.08
 * @modified dioong(AU2) Jindo2 Class�� ����
 */
var Utility = $Class({
	/**
	 * @lends Utility
	 */

	/**
	 * �ʱ�ȭ
	 */
	$init : function(){
		this.wfStopEvent = $Fn(this._stopEvent,this).bindForEvent();
	},


	/**
	 * �̺�Ʈ �⺻���� �� ���?�� ��� ��Ű�� �Լ�
	 * @param {Event} we
	 */
	_stopEvent : function(we){
		we.stop();
	},


	/**
	 * NDS��� �Լ�
	 * @param {String|Number} code
	 * @example
	 *	utility.writelcs(123456789);
	 */
	writelcs : function(code){
		document.createElement("img").src = "http://lcs.naver.com/i{" + code + "}";
	},

	/**
	 * NDS ��� �Լ�
	 * ����, ���α�, �̹���, ����Ʈ ���� Ŭ���� �� �ش� ����Ʈ�� GDID ���� �����.
	 * @param String gdid
	 */
	writeNewLcs : function(gdid, key, value) {
		var etc = {};
		etc[key] = value;

		if(this.isChkNull(key) || this.isChkNull(value) || typeof(key) == "undefined" || typeof(value) == "undefined") {
			lcs_do_gdid(gdid);
		} else {
			lcs_do_gdid(gdid, etc);
		}
	},

	/**
	 * NDS ��� �Լ�
	 * ����, ���α�, �̹���, ����Ʈ ���� Ŭ���� ��ó�� GDID ���� ����� �� ȣ���Ѵ�.
	 * @param String gdid ����Ʈ�� gdid ��
	 * @param String key �α׸𵨸������� ������ key ���� ����Ѵ�. ��) sti
	 * @param String value �α׸𵨸������� ������ key ���� �����ϴ� ���� ��.
	 */
	writeNewLcsNonGdid : function(key, value) {
		if(this.isChkNull(key) || this.isChkNull(value) || typeof(key) == "undefined" || typeof(value) == "undefined") {
			lcs_do();
		} else {
			var etc = {};
			etc[key] = value;
			lcs_do(etc);
		}
	},	
	
	/**
	 * Click LCS �Լ�
	 * @param {String} tagNum1
	 * @param {String} tagNum2
	 * @param {String} tagName
	 * @example
	 *	utility.writeClicklcs(tagNum1, tagNum2, tagName);
	 */
	writeClicklcs : function(tagNum1, tagNum2, tagName){
		 document.createElement("img").src = "http://rd.naver.com/i:" + tagNum1 + "/c:" + tagNum2 +"/t:1?http://section.blog.naver.com/" + tagName;
	},

	/**
	 * http://gn.naver.com/index.html?tmpl=10000
	 * ����Ʈ
	 * @example
	 *	utility.sendGnbGlobalSession();
	 */
	sendGnbGlobalSession : function(){
		document.createElement("img").src = "http://gn.naver.com/index.html?tmpl=10000";
	},


	/**
	 * �յ� ��� ���� �Լ�
	 * @param {String} sText
	 * @return {String}
	 * @example
	 *	sAfterTrim = utility.trim(sBeforeTrim);
	 */
	trim : function(sText){
		if(sText && sText != ""){
			sText = sText.replace(/(^\s*)|(\s*$)/g, '');			
		}
		return sText || "";
	},
	
	/**
	 * null �̳� ���ڿ� üũ �Լ�
	 * @param {String} value
	 * @return {boolean}
	 * @example
	 *	if(utility.isChkNull(sSomeText)){
	 *		somethingDo();
	 *	}
	 */
	isChkNull : function(value){
		var re = false;
		var tmpStr = this.trim(value);
		if (tmpStr == null || tmpStr == "") re = true;
		return re;
	},

	/**
	 * ���� HTMLElement�� ���� ������� �� ���ϴ� �±׸� ã�� �Լ�
	 * @param {HTMLElement} ���� HTMLElement
	 * @param {String} �±� �̸� - �ҹ���
	 * @param {String} Ŭ���� �̸�
	 * @return {HTMLElement}
	 * @example
	 * <div id="testDiv"><a id="testAnchor" href="#" class="_testClass"><img src="" id="testId" /></a></div>
	 *
	 * var elAnchor = utility.getElement($("testId"), "a");
	 * elAnchor == $("testAnchor"); // true
	 *
	 * var elDiv = utility.getElement($("testId"), "div");
	 * elDiv == $("elDiv"); // true
	 *
	 * var elAnchor = utility.getElement($("testId"), "a", "_testClass");
	 * elAnchor == $("testAnchor"); // true
	 */
	getElement : function(el, sTagName, sClassName){
		if(typeof sClassName == "undefined"){
			if(el.tagName.toLowerCase() == sTagName) return el;
			else return $$.getSingle("!" + sTagName, el);
		}else{
			if(el.tagName.toLowerCase() == sTagName && $Element(el).hasClass(sClassName)) return el;
			else return $$.getSingle("!" + sTagName + "." + sClassName, el);
		}
	}
	
});


var utility = new Utility();

// clickcr.js, Version 1.0.5
// Lee Daebeom, 2008.8.14
/* Global variable */
var detect = navigator.userAgent.toLowerCase();
var isSafari = (detect.indexOf('safari') != -1 ? true : false);
var isOpera = (detect.indexOf('opera') != -1 ? true : false);
var max_depth = 4; // Maximum depth of searching for Parent id
var server = "cc.naver.com";
var module = "cc";
if (!nsc) {var nsc = "shopping.main";}

// Function Name : clickcr
// paramenter : obj-  owner of event occurence object, area - click area,  cid - gdID or cid, rank - rank in area, event - predefined event object
// Description : When users click link, this function is called. It request to the server, then the server log data.
function clickcr(obj, area, cid, rank, evt) {
	var p1, p2, p1_id, p2_id, ptarr;
	var pt = "";
	var theEvent = window.event ? window.event : evt;
	var sx = sy = px = py = -1;
	var dBody, dElement, ifrId;
	var mode, clink;
	var o, x, y, w;
	var temp;

	try {
		w = xWindowSize(window);	// size of window
		ifrId = checkIframe(obj);	// check whether it is clicked in iframe or not
		if (ifrId) {	// click object in iframe
			var ifrOffset = findPos(document.getElementById(ifrId));	// Get position of iframe
			if (theEvent.clientX  && theEvent.clientX != "undefined") {
				dBody = document.body;
			    if (dBody.clientLeft && dBody.clientTop) {
					ifrSx = theEvent.clientX - dBody.clientLeft;		//  relative position in iframe
					ifrSy = theEvent.clientY - dBody.clientTop;
			    } else { // firefox bug - clientLeft, clientTop don't work in firefox. It is OK in firefox 3.0
					ifrSx = theEvent.clientX;
					ifrSy = theEvent.clientY;
				}
			}
			// postion of iframe + relative position in iframe
			px = ifrOffset[0] + ifrSx;
			py = ifrOffset[1] + ifrSy;

			// relative position in window
			if (document.body && (document.body.scrollTop || document.body.scrollLeft)) {
				dBody = document.body;
				sx = px - dBody.scrollLeft;
				sy = py - dBody.scrollTop;
			} else if (document.documentElement && (document.documentElement.scrollTop || document.documentElement.scrollLeft)) {
				dElement = document.documentElement;
				sx = px - dElement.scrollLeft;
				sy = py - dElement.scrollTop;
			} else {
				sx = px;
				sy = py;
			}
		} else {	// normal click object
			if (theEvent.clientX  && theEvent.clientX != "undefined") {
				dBody = document.body;
			    if (dBody.clientLeft && dBody.clientTop) {
					sx = theEvent.clientX - dBody.clientLeft;		// relative position in window
					sy = theEvent.clientY - dBody.clientTop;
			    } else { // firefox bug - clientLeft, clientTop don't work in firefox. It is OK in firefox 3.0
					sx = theEvent.clientX;
					sy = theEvent.clientY;
				}
			}

			// IE calculates (clientX,clientY) relativ to window, not content.
			if (document.body && (document.body.scrollTop || document.body.scrollLeft)) {
				px = document.body.scrollLeft + (sx < 0 ? 0: sx);
				py = document.body.scrollTop + (sy < 0 ? 0: sy);
			} else if (document.documentElement && (document.documentElement.scrollTop || document.documentElement.scrollLeft)) {
				dElement = document.documentElement;
				if (dElement.scrollLeft !="undefined") px = dElement.scrollLeft + (sx < 0 ? 0: sx);
				if (dElement.scrollTop !="undefined") py = dElement.scrollTop + (sy < 0 ? 0: sy);
			} else {
				px = (sx < 0 ? 0: sx);
				py = (sy < 0 ? 0: sy);
			}

			if (theEvent.pageX) { px = theEvent.pageX; }
			if (theEvent.pageY) { py = theEvent.pageY; }
		}
	} catch (e) {
	}

	if (area != "") {
		ptarr = area.split(".");
		pt = ptarr[0] +"."+ ptarr[1];
	} else {
		x = obj.parentNode;
		y = x.parentNode;

		p2 = getparent(obj);
		if (p2 == null) {
			return false;
		}
		p1 = getparent(p2);
		if (p1 == null) {
			return false;
		}
		pt = p1.id + "." + p2.id;
	}

	// Case of no redirection
	// 1. Open link to new window or target of other window or object of its window ( ex. iframe)
	// 2. Use javascript scheme (javascript:)
	// 3. Use fragment at the first character of href (ex. #top)
	// 4. No use href
	if (obj.href) {
		if ((obj.target && obj.target != "_self") || (obj.href.toLowerCase().indexOf("javascript:") != -1)
			|| obj.getAttribute("href",2).charAt(0) == '#'
			|| (obj.href.indexOf("#") != -1 && (obj.href.substr(0,obj.href.indexOf("#")) == document.URL))) {
			mode = 0;
		} else {	// Case of redirection - Open link to its window (no target, _self)
			mode = 1;
		}
	} else {
		mode = 0;
	}

	if (obj.href) {
		if (obj.href.indexOf("http://"+server) == 0) {
			clink = obj.href;
		} else {
			clink = "http://" + server + "/"+ module + "?a=" + pt + "&r=" + rank + "&i=" + cid + "&nsc=" + nsc + "&w=" + w + "&px="+ px + "&py=" + py + "&sx="+ sx + "&sy=" + sy + "&m=" + mode + "&u="+encodeURIComponent(obj.href);
		}
	} else {
		clink = "http://" + server + "/"+ module + "?a=" + pt + "&r=" + rank + "&i=" + cid + "&nsc=" + nsc + "&w=" + w + "&px="+ px + "&py=" + py + "&sx="+ sx + "&sy=" + sy + "&m=" + mode + "&u=''";
	}

	if (mode == 1)  {	// Redirection
		temp = obj.innerHTML;
		obj.href = clink;

		if (obj.innerHTML != temp) {
			obj.innerHTML = temp;
			obj.innerHTML = temp;
		}
	} else if (document.images)  {	// No redirection
		var timestr = new Date().getTime();
		clink += "&time="+ timestr;		// Aviod image cache

		if (isSafari && !obj.href) {
			var b = c = new Date();
			while ((b.getTime() - c.getTime()) < 100) b = new Date();
			(new Image()).src = clink;
		} else {
			(new Image()).src = clink;
		}
	}

	return true;
}

// Function Name : getparent
// paramenter : obj-  owner of event occurence object
// Description : Get id of parent element
function getparent(obj) {
	var p = obj.parentNode;
	var depth = 0;
	while (1) {
		if ( p.id != null && p.id != "") {
			return p;
		}
		else {
			depth++;
			p = p.parentNode;
		}
		if (depth >= max_depth) {
			return null;
		}
	}
}

// Function Name : xWindowSize
// paramenter : win -  window object
// Description : Calculates inner width of browser window.
 function xWindowSize(win) {
	if (!win) win = window;
	var winWidth = 0;
	if (win.innerWidth) {
		// most non-IE
		winWidth = win.innerWidth;
		// including scroll bar !! //
		if ( typeof(win.innerWidth) == 'number') {
			var scrollbarWidth = getScrollBarWidth();
			winWidth = win.innerWidth - scrollbarWidth; // Opera includes scrollbar width at innerWidth
		}
	} else if (document.documentElement && document.documentElement.clientWidth) {
		//IE 6+ in 'standards compliant mode'
		winWidth = document.documentElement.clientWidth;
	} else if( document.body && ( document.body.clientWidth || document.body.clientHeight ) ) {
		//IE 4 compatible
		winWidth = document.body.clientWidth;
	}
	return winWidth;
}

// Function Name : getScrollBarWidth
// Description : Get scrollbar width in order to calculate browser size of Opera.
function getScrollBarWidth () {
	var inner = document.createElement('p');
	inner.style.width = '200px';
	inner.style.height = '200px';

	var outer = document.createElement('div');
	outer.style.position = 'absolute';
	outer.style.top = '0px';
	outer.style.left = '0px';
	outer.style.visibility = 'hidden';
	outer.style.width = '200px';
	outer.style.height = '150px';
	outer.style.overflow = 'hidden';
	outer.appendChild (inner);

	document.body.appendChild (outer);
	var w1 = inner.offsetWidth;
	outer.style.overflow = 'scroll';
	var w2 = inner.offsetWidth;

	if (w1 == w2) w2 = outer.clientWidth;

	document.body.removeChild (outer);

	return (w1 - w2);
}

// Function Name : findPos
// Parameter : obj - owner of event occurence object
// Description : Get offsetLeft, offsetTop
function findPos(obj) {
	var curleft = curtop = 0;

	if (obj.offsetParent) {
		do {
			curleft += obj.offsetLeft;
			curtop += obj.offsetTop;
		} while (obj = obj.offsetParent);
	}
	else if (obj.x || obj.y)			// for safari of old version
	{
		if (obj.x) curleft += obj.x;
		if (obj.y) curtop += obj.y;
	}
	return [curleft, curtop];
}

// Function Name : checkIframe
// Parameter : obj - owner of event occurence object
// Return Value : iframe ID or false
// Description : Check whether it is clicked in iframe or not
function checkIframe(obj) {
	var oriURL = document.URL;
	var p = obj.parentNode;
	var docObj;
	var ifrId;

	while (1) {
		if (p.nodeName.toLowerCase() == "#document") {
			if (p.parentWindow) {		// IE, Opera
				docObj = p.parentWindow;
			} else {	// Firefox, Safari
				docObj = p.defaultView;
			}

			if (docObj.frameElement != null && docObj.frameElement != "undefined" ) {
				if (docObj.frameElement.nodeName.toLowerCase() == "iframe") {
					ifrId = docObj.frameElement.id;	// Get iframe id
					if (!ifrId) return false;
					return ifrId;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			p = p.parentNode;
			if (p == null || p == "undefined") return false;
		}
	}
}
