package ladder;

import core.NaturalNumber;

public class ManualLadderCreator implements LadderCreator {
	private Row[] rows;

	public ManualLadderCreator(NaturalNumber cntOfRow, NaturalNumber noOfPerson) {
		rows = new Row[cntOfRow.getNumber()];
		for (int i = 0; i < cntOfRow.getNumber(); i++) {
			rows[i] = new Row(noOfPerson);
		}
	}

	private boolean rowIsOverLimit(NaturalNumber row) {
		return row.toArrayIndex() > rows.length - 1;
	}

	@Override
	public void drawLine(NaturalNumber row, NaturalNumber col) {
		if (rowIsOverLimit(row)) {
			throw new IllegalArgumentException(String.format(
					"사다리 최대 높이를 넘어섰습니다. 현재 값 : %d", row.getNumber()
			));
		}
		rows[row.toArrayIndex()].drawLine(col);
	}

	@Override
	public Row[] getRows() {
		return this.rows;
	}
}
