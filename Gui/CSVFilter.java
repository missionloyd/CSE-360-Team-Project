import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.*;

public class CSVFilter extends FileFilter{

	@Override
	public boolean accept(File f) {
		// TODO Auto-generated method stub

		if(f.isDirectory()) {
			return true;
		} else {
			return f.getName().toLowerCase().endsWith(".csv");
		}
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return ".csv";
	}

}
