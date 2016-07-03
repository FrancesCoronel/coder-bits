function IPAddressValidation() {
	var lineLength = arguments[0];
	for (var i = 1; i <= lineLength; i++) {
		var currentArg = arguments[i];
		var split = currentArg.split('.');
		var splitLength = split.length;
		for (var j = 0; j < splitLength; j++) {
			if (split[j] <= -1 || split[j] > 255 || isNaN(parseFloat(split[j])) || split[j].indexOf("") != -1){
				var bool = true;
			} else {
				var bool = false;
			}
		}
		if (bool === true) {
			console.log("IPv4")
		} else {
			console.log("Not IPv4")
		}
	}
}

IPAddressValidation(3, "121.18.19.20", "123.19.20.12", "124.91.21.34");