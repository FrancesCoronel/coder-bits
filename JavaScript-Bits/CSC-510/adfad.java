class Coins {
	public static void main (String args[]) {
		double  money = 1.73;

		while (money > 0.0 ){
			if (money >= 1) {
				System.out.println(Math.floor(money/1)+" dollars");
				money -= Math.floor(money/1)*(double)1;

			}
			else if (money>=.25) {
				System.out.println(Math.floor(money/.25)+" quarters");
				money-=Math.floor(money/.25)*(double).25;

			}
			else if (money>=.10) {
				System.out.println(Math.floor(money/.10)+" Dimes");
				money-=Math.floor(money/.10)*(double).10;
			}
			else if (money>=.05) {
				System.out.println(Math.floor(money/.05)+" Nickels");
				money-=Math.floor(money/.05)*(double).05;
			}
			else if (money>=.01) {
				System.out.println(Math.round(money/.01)+" Penny");
				money-=Math.round(money/.01)*(double).01;
			}
		}
	}
}