public class EHanshi {
	/**
	 * 理解创建唯一的对象， 并且设置构造函数为空
	 * <p>
	 * 单例模式的主要目的是确保某个类在系统中有且只有一个对象，比如这个对象维持整个系统的共享状态等。
	 */
	private static EHanshi target = new EHanshi();

	private EHanshi() {

	}

	public static EHanshi getInstance() {
		return target;
	}

}
