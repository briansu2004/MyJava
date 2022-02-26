import java.util.UUID;

public class UuidExample {
	public static void generateRandomUuid(int num) {
		/***** Generate Version 4 UUID - Randomly Generated UUID *****/
		UUID uid = null;
		for (int i = 1; i < num; i++) {
			/***** Generating Random UUID's *****/
			uid = UUID.randomUUID();
			System.out.println("Generated UUID?= " + uid + ", UUID Version?= " + uid.version() + ", UUID Variant?= " + uid.variant() + "\n");
		}
	}

	public static void main(String[] args) {
		int num = 4;
		generateRandomUuid(num);
	}
}