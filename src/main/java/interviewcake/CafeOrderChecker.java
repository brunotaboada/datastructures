package interviewcake;

public class CafeOrderChecker {

	public static void main(String[] args) {

		int[] takeout = new int[] { 17, 8, 24 };
		int[] dineIn = new int[] { 12, 19, 2 };

	}

	public static boolean isFirstComeFirstServed(int[] takeOutOrders, int[] dineInOrders, int[] servedOrders) {
		int takeOutOrdersIndex = 0;
		int dineInOrdersIndex = 0;

		for (int order : servedOrders) {

			// if we still have orders in takeOutOrders
			// and the current order in takeOutOrders is the same
			// as the current order in servedOrders
			if (takeOutOrdersIndex < takeOutOrders.length && order == takeOutOrders[takeOutOrdersIndex]) {
				takeOutOrdersIndex++;

				// if we still have orders in dineInOrders
				// and the current order in dineInOrders is the same
				// as the current order in servedOrders
			} else if (dineInOrdersIndex < dineInOrders.length && order == dineInOrders[dineInOrdersIndex]) {
				dineInOrdersIndex++;

				// if the current order in servedOrders doesn't match the current
				// order in takeOutOrders or dineInOrders, then we're not serving first-come,
				// first-served
			} else {
				return false;
			}
		}

		// check for any extra orders at the end of takeOutOrders or dineInOrders
		if (dineInOrdersIndex != dineInOrders.length || takeOutOrdersIndex != takeOutOrders.length) {
			return false;
		}

		// all orders in servedOrders have been "accounted for"
		// so we're serving first-come, first-served!
		return true;
	}
}
