package datastructures;

public class BuildTreeInteger extends BuildTree<Integer> {

	@Override
	protected boolean isRootId(Integer parendId) {
		if (parendId == -1) {
			return true;
		}
		return false;
	}

	@Override
	protected Integer getParentId(Integer value) {
		int result = -1;
		switch (value) {
		case 3:
			result = 8;
			break;

		case 8:
		case 9:
			result = 5;
			break;

		case 1:
		case 2:
			result = 3;
			break;

		case 4:
			result = 9;
			break;

		case 6:
			result = 4;
			break;

		case 11:
		case 12:
			result = 6;
			break;

		default:
			break;
		}
		return result;
	}

}
