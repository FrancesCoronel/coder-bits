var getSubstrings = function(str) {
	var len = str.length;
	var results = [];
	for (var i = 0; i < len; i++) {
		for (var j = 1; j <= (len - i); j++) {
			subString = str.substring(i, i + j).toLowerCase();
			results.push(subString);
		}
	}
	var noDuplicates = eliminateDuplicates(results);
	console.log(noDuplicates);
	return noDuplicates.length;
};

function eliminateDuplicates(arr) {
	var i,
		len = arr.length,
		out = [],
		obj = {};
	for (i = 0; i < len; i++) {
		obj[arr[i]] = 0;
	}
	for (i in obj) {
		out.push(i);
	}
	return out;
}

console.log(getSubstrings("IIIIIIIIII"));