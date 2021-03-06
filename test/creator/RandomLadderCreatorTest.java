package creator;

import core.NaturalNumber;
import core.RandomNaturalNumber;
import creator.RandomLadderCreator;
import ladder.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class RandomLadderCreatorTest {

	@Test
	void testGenerateStartPosition() {
		ManualLadderCreator manualLadderCreator = new ManualLadderCreator(new NaturalNumber(3), new NaturalNumber(4));
		new RandomLadderCreator(manualLadderCreator);
	}
}
