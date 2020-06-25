/**
*	@name jsFMVC
*	@class 자바스크립트 FMVC
*	@description 자바스크립트에서 MVC를 사용할 수 있도록 도와주며 FMVC(Form , Model, View, Controller)로 구성되어 있다.
*	@since 2010.1.15
*	@version 1.0.0
*	@author blankus
*/
var jsMVC = {
	_Controller : [], 
	_Form : [], 
	isLog : true, 
	version : "1.0.0"
};

jsMVC.$Controller = function(name, instance){
	this[name] = instance;
};

jsMVC.Event = function(){
	this._listeners = [];
};

jsMVC.Event.prototype = {
    attach : function(listener) {this._listeners.push(listener)},
    notify : function(fnArgs) {
        for (var i=0, count=this._listeners.length; i<count; i++) {	
            this._listeners[i](fnArgs);
        }
    }
};

jsMVC.Form = function(){
		_Form : [];
};

jsMVC.Form.prototype = {
	getElementValue : function(element){
		if(typeof element == "object") return element.value;
	},
	
	setElementValue : function(element, val){
		if(typeof element == "object") element.value = val;
	},
	
	saveForm : function(fName){
		jsMVC._Form.push(fName);
	},
	
	loadForm : function(fName){
		var f = jsMVC._Form;
		for(var i=0; i<f.length; i++){
			if(f[i] == fName) {
				return document[f[i]];
			}
		}
	}
}


jsMVC.setController = function(instanceName, klass){
	if(typeof jsMVC._Controller[instanceName] == "undefined") jsMVC._Controller[instanceName] = new klass();
	else jsMVC.Error("[registController] duplicated Controller's instance name : "+instanceName);
};

jsMVC.setModel = function(controllerName, instanceName, klass){
	if(typeof jsMVC._Controller[controllerName] != "undefined"){
		jsMVC.getController(controllerName).$jsMVC(instanceName, new klass());
	}else jsMVC.Error("[registModel] '"+controllerName+"' not found");
};

jsMVC.getModel = function(controllerName, instanceName){
	if(typeof jsMVC._Controller[controllerName] != "undefined"){
		if(typeof jsMVC.getController(controllerName)[instanceName] != "undefined"){
			return jsMVC.getController(controllerName)[instanceName];
		}else jsMVC.Error("[getModel] '"+controllerName+"' not found : " + instanceName);
	}else jsMVC.Error("[getModel] '"+controllerName+"'  not found : " + instanceName);
};

jsMVC.setView = function(controllerName, instanceName, klass){
	if(typeof jsMVC._Controller[controllerName] != "undefined"){
		jsMVC.getController(controllerName).$jsMVC(instanceName, new klass());
	}else jsMVC.Error("[registView] '"+controllerName+"' not found");
};

jsMVC.getView = function(controllerName, instanceName){
	if(typeof jsMVC._Controller[controllerName] != "undefined"){
		if(typeof jsMVC.getController(controllerName)[instanceName] != "undefined"){
			return jsMVC.getController(controllerName)[instanceName];
		}else jsMVC.Error("[getView] '"+controllerName+"'  not found : " + instanceName);
	}else jsMVC.Error("[getView] '"+controllerName+"'  not found : " + instanceName);
};

jsMVC.setForm = function(controllerName, instanceName, klass){
	if(typeof jsMVC._Controller[controllerName] != "undefined"){
		for(var i in jsMVC.Form.prototype){
			klass.prototype[i] = jsMVC.Form.prototype[i];
		}
		jsMVC.getController(controllerName).$jsMVC(instanceName, new klass());
	}else jsMVC.Error("[registForm] '"+controllerName+"' not found");
};

jsMVC.getForm = function(controllerName, instanceName){
	if(typeof jsMVC._Controller[controllerName] != "undefined"){
		if(typeof jsMVC.getController(controllerName)[instanceName] != "undefined"){
			return jsMVC.getController(controllerName)[instanceName];
		}else jsMVC.Error("[getForm] '"+controllerName+"'  not found : " + instanceName);
	}else jsMVC.Error("[getForm] '"+controllerName+"'  not found : " + instanceName);
};

jsMVC.getController = function(instanceName){
	if(typeof jsMVC._Controller[instanceName] != "undefined") return jsMVC._Controller[instanceName];
	else jsMVC.Error("[getController] '"+instanceName+"' not found");
};

jsMVC.Error = function(err){
	throw new Error(err);
};

jsMVC.Log = function(msg){
	if(jsMVC.isLog == true){
		if(typeof console == "object") console.log(msg);
	}
};
