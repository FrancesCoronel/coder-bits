$(document).ready(function(){$("#image1").click(function(){"buttonBefore.png"===$("#image1").attr("src")?$("#image1").attr("src","buttonAfter.png"):$("#image1").attr("src","buttonBefore.png")}),$("#image2").click(function(){"planeBefore.png"===$("#image2").attr("src")?$("#image2").attr("src","planeAfter.png"):$("#image2").attr("src","planeBefore.png")}),$("#image3").click(function(){"bluetoothBefore.png"===$("#image3").attr("src")?$("#image3").attr("src","bluetoothAfter.png"):$("#image3").attr("src","bluetoothBefore.png")}),$("#image4").click(function(){"wifiBefore.png"===$("#image4").attr("src")?$("#image4").attr("src","wifiAfter.png"):$("#image4").attr("src","wifiBefore.png")}),$("#image5").click(function(){"sunBefore.png"===$("#image5").attr("src")?$("#image5").attr("src","sunAfter.png"):$("#image5").attr("src","sunBefore.png")}),$("#checkDate").click(function(){var e,t,n;e=document.getElementById("dd").value,t=document.getElementById("mm").value;var a=0;1>t||t>12?n="Month not valid.":(n="Great, thanks!",a=1),1===a&&(n=1>t||t>31?"Day not valid.":2===t&&e>28?"February cannot have more than 28 days.":(4===t||5===t||6===t||8===t||9===t||11===t)&&e>30?"This month cannot have more than 30 days.":"Great, thanks!"),document.getElementById("checkedDate").innerHTML=n}),$("#checkVowels").click(function(){var e="";e=document.getElementById("theString").value;for(var t=0,n=0,a=0,r=0,m=0,c=0;c<e.length;c++)"a"===e[c]||"A"===e[c]?t++:"e"===e[c]||"E"===e[c]?n++:"i"===e[c]||"I"===e[c]?a++:"o"===e[c]||"O"===e[c]?r++:("u"===e[c]||"U"===e[c])&&m++;document.getElementById("theavowels").innerHTML=t,document.getElementById("theevowels").innerHTML=n,document.getElementById("theivowels").innerHTML=a,document.getElementById("theovowels").innerHTML=r,document.getElementById("theuvowels").innerHTML=m}),$("#getStats").click(function(){var e=0,t=document.getElementById("number1").value,n=document.getElementById("number2").value,a=document.getElementById("number3").value,r=document.getElementById("number4").value,m=document.getElementById("number5").value;t=parseInt(t)||0,n=parseInt(n)||0,a=parseInt(a)||0,r=parseInt(r)||0,m=parseInt(m)||0;var c=Math.min(t,n,a,r,m),o=Math.max(t,n,a,r,m);e+=t+n+a+r+m;var i=e/5;document.getElementById("themin").innerHTML=c,document.getElementById("themax").innerHTML=o,document.getElementById("thesum").innerHTML=e,document.getElementById("theaverage").innerHTML=i})});