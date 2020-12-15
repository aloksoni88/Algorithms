package com.garbagecollection;

class Example {
	public static void main(String[] args) {
		Test t1 = new Test();
		Test t2 = new Test();
		t1.m1(t2);

		System.out.println("t1.x:" + t1.x + ", " + "t1.y:" + t1.y);
		System.out.println("t2.x:" + t2.x + ", " + "t2.y:" + t2.y);

		t1.m1(new Test());
		System.out.println("t1.x:" + t1.x + ", " + "t1.y:" + t1.y);
		System.out.println("t2.x:" + t2.x + ", " + "t2.y:" + t2.y);

		Test t = new Test().m1(new Test());
		System.out.println("t1.x:" + t.x + ", " + "t1.y:" + t.y);

		System.out.println("t1.x:" + new Test().x + ", " + "t1.y:" + new Test().y);
	}

}

class Test {
	int x = 10;
	int y = 20;

	Test m1(Test t) {
		t.x = t.x + 1;
		t.y = t.y + 1;
		return t;
	}
}
