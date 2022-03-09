package ladder;

import core.NaturalNumber;

public class Ladder {
	private Row[] rows;

	public Ladder(NaturalNumber cntOfRow, NaturalNumber noOfPerson) {
		rows = new Row[cntOfRow.getNumber()];
		for (int i = 0; i < cntOfRow.getNumber(); i++) {
			rows[i] = new Row(noOfPerson);
		}
	}

	public static String generate(Row[] rows, NaturalNumber height, NaturalNumber noOfPerson) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < rows.length; i++) {
			Row row = rows[i];
			Node[] nodes = row.getNodes();
			for (int j = 0; j < nodes.length; j++) {
				Node node = nodes[j];
				if (node.equals(Node.createCenterNode())) {
					sb.append("0");
				} else if (node.equals(Node.createLeftNode())) {
					sb.append("-1");
				} else if (node.equals(Node.createRightNode())) {
					sb.append("1");
				}
				if (height.toArrayIndex() == i && noOfPerson.toArrayIndex() == j) {
					sb.append("*");
				}
				sb.append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public void drawLine(NaturalNumber row, NaturalNumber col) {
		if (rowIsOverLimit(row)) {
			throw new IllegalArgumentException(String.format(
					"사다리 최대 높이를 넘어섰습니다. 현재 값 : %d", row.getNumber()
			));
		}
		rows[row.toArrayIndex()].drawLine(col);
	}

	private boolean rowIsOverLimit(NaturalNumber row) {
		return row.toArrayIndex() > rows.length - 1;
	}

	public Marker run(Marker nthPerson) {
		for (int i = 0; i < rows.length; i++) {
			Row row = rows[i];
			nthPerson = row.move(nthPerson);
			String result = generate(rows, new NaturalNumber(i+1), nthPerson);
			System.out.println(result);
		}
		return nthPerson;
	}
}
