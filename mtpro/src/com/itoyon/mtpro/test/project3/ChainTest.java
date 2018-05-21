package com.itooy.project3;

/**
 * @Description: TODO(用一句话描述这个类的作用)
 * @author: Stone
 * @date: 2018年4月19日 下午10:25:59
 */
public class ChainTest {

	/**
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param args    设定文件
	 * @return void    返回类型
	 * @throws
	 */
	public static void main(String[] args) {
		ChainTest ct =new ChainTest();
		try {
			ct.test2();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void test() throws DrunkException {
		throw new DrunkException("开车别喝酒！"); 
	}
	
	public void test2() {
		try {
			test();
		} catch (DrunkException e) {
			RuntimeException re = new RuntimeException(e);
//			RuntimeException re = new RuntimeException("司机一滴酒，亲人两行泪！");
//			re.initCause(e);
			throw re;
		}
	}

}
