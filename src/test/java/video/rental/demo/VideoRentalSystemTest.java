package video.rental.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class VideoRentalSystemTest {

	private GoldenMaster goldenmaster = new GoldenMaster();

	@Disabled
	@Test
	void generate_golden_master() {
		// Given (Arrange)

		// When (Act)
		goldenmaster.generate();

		// Then (Assert)
	}

	@EnabledOnOs(OS.WINDOWS)
	@Test
	void check_run_result_against_golden_master() {
		// Given (Arrange)
		String expected = goldenmaster.getGoldenMaster();

		// When (Act)
		String actual = goldenmaster.getRunResult();

		// Then (Assert)
		assertEquals(expected, actual.replaceAll("\r\n", "\n"));
	}

	@EnabledOnOs({ OS.LINUX, OS.MAC })
	@Test
	void check_run_result_against_golden_master2() {
		// Given (Arrange)
		String expected = goldenmaster.getGoldenMaster();

		// When (Act)
		String actual = goldenmaster.getRunResult();

		// Then (Assert)
		assertEquals(expected, actual);
	}

}
