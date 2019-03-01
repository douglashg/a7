var xhr;
var action;
var form;
var msg;
var progressBar;
var list;
var field;
var grid;
var network;
var geolocation;
var language;
var log_=true; 

//#### XMLHttpRequest ####
if (window.XMLHttpRequest) { //Mozilla, Safari, ...
 xhr = new XMLHttpRequest();
} else if (window.ActiveXObject) { // IE 8 and older
 network = ActiveXObject('WScript.Network');
 xhr = new ActiveXObject("Microsoft.XMLHTTP");
 try { xhr = new ActiveXObject("Msxml2.XMLHTTP"); } catch (e) {
   try { xhr = new ActiveXObject("Microsoft.XMLHTTP"); } catch (e) { alert('Microsoft/Msxml2 XMLHTTP '+lang_main_msg_error_xmlhttprequest+' '+e);}
 }
} else {
 alert(lang_main_msg_error_xmlhttprequest);
}
//#### Log ####
function log(msgLog){ if(log_ ===true)console.log(msgLog);}

//#### Language ####
language = navigator.language;

//#### Geolocation ####
if (navigator.geolocation){
 geolocation = navigator.geolocation.watchPosition(showPosition);
}
function showPosition(position) {
 return position.coords.latitude+'|'+position.coords.longitude; 
}

//#### Json ####
function toJson(elements){
	
 var json = "{ ";

 if(elements!=null){
	 
   for(i=0;i< elements.length;i++){
	
	if(elements[i].value!= null && elements[i].value!=''){
     json=json+"\""+elements[i].name+"\":";
	  
     if(elements[i].type ==='number'
      ||elements[i].type ==='hidden'
      ||elements[i].type ==='select'
      ||elements[i].type ==='tel'){
      json=json+elements[i].value+",";
     }else if(form.elements[i].type ==='text' 
      || elements[i].type ==='password'
      || elements[i].type ==='email'){
      json=json+"\""+elements[i].value+"\",";
     }else{
	   json=json+"\""+elements[i].value+"\","; 
     }
	}
   }
 }
 json = json.substring(0,json.length-1)+"}";
 log('json send:'+json);
 return json; 
}

function readystate () {

 if(progressBar!==null){  
  switch(xhr.readyState) {
   case 0:  progressBar.value = '20'; break;
   case 1:  progressBar.value = '40'; break;
   case 2:  progressBar.value = '60'; break;
   case 3:  progressBar.value = '80'; break;
   case 4:  progressBar.value = '0'; actionDs(); break;
   default: progressBar.value = '0';
  }
 } else {
  if(xhr.readyState === 4){
	actionDs();
  } 
 }
}

function actionDs() {
log('f:update');
log('action:'+action+' status:'+xhr.status);
log('json return:'+xhr.responseText);
 
 switch(action) {
  case    'byId':   byId(); break;
  case    'list':   list(); break;
  case  'insert': insert(); break;
  case  'update': update(); break;
  case  'delete':delete_(); break;
  case  'return':return_(); break;
  case 'if_existe_return': list = JSON.parse(xhr.responseText); if_exist_return(); break;
  default:                 list = JSON.parse(xhr.responseText); return_();
 }
}

function rest(action,url,type,form,asic) {
log('f:rest');
 this.action = action;
 this.form = form;
 this.progressBar = document.getElementById('progress_bar');
 this.msg = document.getElementById('msg');
 msgStyle('msg','');
	 
 xhr.onreadystatechange = readystate;
 xhr.open(type.toUpperCase(),url,asic);
 xhr.setRequestHeader('Content-Type',"application/json; charset=UTF-8");
 xhr.send(toJson(form.elements));
 
}

function byId() {}

function list() {
log('f:list');
 list = JSON.parse(xhr.responseText);
	  
  if(list === null || list.length === 0){
   msgStyle('msgWarn',lang_msg_warn_registers_not_found);
   document.getElementById('grid').innerHTML = '';
  }else{
   msgStyle('msgSuce',lang_msg_succes_registers+list.length);
   
   var row;
   var colunms;
   var propValue;
   var propriety;
   var value;
   
   grid = '<table id="gridTable" class="gridTable">';
   
   row = JSON.stringify(list[0]);
   colunms = row.split(',');
   grid = grid+'<tr>';
   
   for(y=0;y<colunms.length;y++){
	 propValue = colunms[y].split(':');
	 propriety = propValue[0].replace('{','').replace('"','').replace('"','');
	 grid = grid+'<th>'+propriety+'</th>';
   }
   
   grid = grid+'</tr>';
   
   for(i=0;i<list.length;i++){
	row = JSON.stringify(list[i]);
	colunms = row.split(',');
	grid = grid+'<tr>';
	
	for(y=0;y<colunms.length;y++){
	 propValue = colunms[y].split(':');
	 propriety = propValue[0].replace('{','').replace('"','').replace('"','');
	 value = propValue[1].replace('}','');
	 if(propriety.substring(0, 2)=='id'){
	  grid = grid+'<td><a href="\\portal\\services\\'+propriety.substring(2, propriety.length).toLowerCase()+'.html" >'+value+'</a></td>';
	 }else{
	  grid = grid+'<td>'+value+'</td>';
	 }
	}
	
	grid = grid+'</tr>';
   }
   grid = grid+'</table>';
   document.getElementById('grid').innerHTML = grid;
  }
}

function insert() {
log('f:insert');	
 if(xhr.status > 199 && xhr.status < 300){
  msg.style.color='green';
  msg.innerText=lang_msg_succes_insert;   
 }else{
  msg.style.color='red';
  msg.innerText=lang_msg_error_insert;  
 }
}

function update() {
log('f:update');
 if(xhr.status ==200){
  msg.style.color='green';
  msg.innerText=lang_msg_succes_update;   
 }else{
  msg.style.color='red';
  msg.innerText=lang_msg_error_update;  
 }
}

function delete_() {
log('f:delete');	
 if(xhr.status === 201){
  msg.style.color='green';
  msg.innerText=lang_msg_succes_delete;   
 }else{
  msg.style.color='red';
  msg.innerText=lang_msg_error_delete;  
 }
}

function required(field) {
log('f:required');
 if(field.value != null && field.value.trim()!=''){
   field.style.border = '2px solid green';
   field.alt = field.name+'='+field.value+' '+lang_msg_succes_valid;
   return true;
 } else {
   field.style.border = '2px solid red';
   field.alt = field.name+' '+lang_msg_error_required;
   return false;
 }
}

function if_exist (tabela,field){	 
log('f:if_exist');
 if(required(field)){
  this.field = field;
  var formValidation = document.createElement("form");
  
  var input = document.createElement("input");
  input.setAttribute('name', field.name); 
  input.setAttribute('value',field.value); 
  input.setAttribute('type', field.type); 
  
  formValidation.appendChild(input);
  
  rest('if_existe_return','\\'+tabela+'\\list','POST',formValidation,true);
 } 	
}

function if_exist_return() {
log('f:if_exist_return');
 if(list.length === 0){
  field.style.border = '2px solid green';
  field.alt = field.name+'='+field.value+' '+lang_msg_succes_valid;
  return false;
 } else {
  field.style.border = '2px solid red';
  field.alt = field.name+'='+field.value+' '+lang_msg_error_already_exists;
  return true;
 }
}

function msgStyle(className,mensagem) {
log('f:msgStyle');
 msg.innerText = mensagem;
 msg.className=className;
}

//###### Include ######
function include() {
log('f:include');
 var file;
 var element;
 var elements = document.getElementsByTagName('INCLUDE');
	 
 for(i = 0; i < elements.length; i++) {
  element = elements[i];
  file = element.getAttribute('src');
  
  if(file) {
   xhr.onreadystatechange = function() {
    if(this.readyState == 4) {
     if(this.status == 200) {element.innerHTML = this.responseText;}
      if(this.status == 404) {element.innerHTML = 'include '+lang_msg_error_not_found;}
       element.removeAttribute('src');
       include();
    }
   }      
   xhr.open('GET', file, true);
   xhr.send();
   return;
  }
 }
}
//#### Lang ######

/*
import i18next from 'i18next';
​
i18next.init({
  lng: 'en',
  debug: true,
  resources: {
    en: {
      translation: {
        "key": "hello world"
      }
    }
  }
}, function(err, t) {
  // initialized and ready to go!
  document.getElementById('output').innerHTML = i18next.t('key');
});
*/