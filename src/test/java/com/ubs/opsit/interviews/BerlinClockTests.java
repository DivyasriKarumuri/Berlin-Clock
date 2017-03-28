package com.ubs.opsit.interviews;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Rule;

public class BerlinClockTests {
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	private BerlinClock berlinClock = new BerlinClock();

	@Test
	public void testInvalidTime() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Invalid time");
		berlinClock.convertTime("-10:33:98");
	}
	@Test
	public void testTimeFormat() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Invalid time");
		berlinClock.convertTime("10:33");
	}
	
	@Test
	public void testSecsLamp() {
		assertThat(berlinClock.getSecondsRow(0).toString()).isEqualTo("Y");
		assertThat(berlinClock.getSecondsRow(3).toString()).isEqualTo("O");
	}
	
	@Test
	public void testFirstRow() {
		assertThat(berlinClock.getFirstRow(0).toString()).isEqualTo("OOOO");
		assertThat(berlinClock.getFirstRow(7).toString()).isEqualTo("ROOO");
		assertThat(berlinClock.getFirstRow(13).toString()).isEqualTo("RROO");
		assertThat(berlinClock.getFirstRow(24).toString()).isEqualTo("RRRR");
	}

	@Test
	public void testSecondRow() {
		assertThat(berlinClock.getSecondRow(0).toString()).isEqualTo("OOOO");
		assertThat(berlinClock.getSecondRow(23).toString()).isEqualTo("RRRO");
		assertThat(berlinClock.getSecondRow(24).toString()).isEqualTo("RRRR");
	}

	@Test
	public void testThirdRow() {
		assertThat(berlinClock.getThirdRow(17).toString()).isEqualTo("YYROOOOOOOO");
		assertThat(berlinClock.getThirdRow(59).toString()).isEqualTo("YYRYYRYYRYY");
	}

	@Test
	public void testFourthRow() {
		assertThat(berlinClock.getFourthRow(0).toString()).isEqualTo("OOOO");
		assertThat(berlinClock.getFourthRow(59).toString()).isEqualTo("YYYY");
	}
}