function isPalindrome(str) {
		
		var str = str.replace(/[^a-zA-Z]+/g, '').toLowerCase();
		var split = str.split('').reverse().join('');
		console.log("Edited string: ", str);
		console.log("Reversed string: ", split);
		if (split == str) {
			console.log("true");
		} else {
			console.log("false");
		}


}

isPalindrome("A but tuba")

function isPalindrome(str) {
	// test with spaces in string
	// if (str.indexOf(' ') >= 0) {
	// var split = str.split(' ');
	// var reversed = split.reverse();
	// var joined = reversed.join(' ');
	var cleanString = str.replace(/[^a-zA-Z0-9]+/g, '').toLowerCase();
	var palindrome = str.split('').reverse().join('');
	if (cleanString === palindrome) {
		console.log("true");
	} else {
		console.log("false");
	}
}