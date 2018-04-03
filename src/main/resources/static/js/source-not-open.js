/**
 * 禁止F12
 * 禁止鼠标右键单击
 * 禁止Ctrl+Shift+I
 */
 window.onload = function() {
     document.onkeydown = function() {
         var e = window.event || arguments[0];
         //1.屏蔽F12
         if(e.keyCode == 123) {
              return false;
         //2.屏蔽Ctrl+Shift+I
         } else if((e.ctrlKey) && (e.shiftKey) && (e.keyCode == 73)) {
             return false;
         //3.屏蔽Shift+F10
         } else if((e.shiftKey) && (e.keyCode == 121)){
             return false;
        }
     };
     //4.屏蔽右键单击
     document.oncontextmenu = function() {
         return false;
	}
 	 //5.禁止页面内的文本被选取
     //document.onselectstart=new Function('event.returnValue=false;');
     if(document.all)
     { 
    	 debugger
        document.onselectstart= function(){return false;}; //for ie
     }
     else
     { 	 document.onmousedown= function(){return false;};
    	 document.onmouseup= function(){return true;};
     }

}