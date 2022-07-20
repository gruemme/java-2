

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Uebung1 {

	public List<String> readLinesFromInputStream(InputStream stream) throws IOException {
		InputStreamReader streamReader = new InputStreamReader(stream);
		BufferedReader reader = new BufferedReader(streamReader);

		List<String> lines = new ArrayList<>();
		String line;
		while (reader.ready()) {
			line = reader.readLine();
			lines.add(line);
		}

		return lines;
	}
}
