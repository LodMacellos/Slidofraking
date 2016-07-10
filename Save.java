package saves;

import java.io.*;

public class Save implements Serializable {
	// Class needs serialVersionUID
	private static final long serialVersionUID = 2L;

	public int level = 1;
	int number;

	public Save(int number){
		this.number = number;
	}

	public void incrLevel(){
		level++;
	}

	public void save(){
		try {
			FileOutputStream fileOut = new FileOutputStream("/save/save" + number + ".ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);
			out.close();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
