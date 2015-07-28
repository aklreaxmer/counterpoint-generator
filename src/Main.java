import java.util.ArrayList;
import java.util.Random;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;


public class Main
{
	
	public static int SPECIES = 1;
	public static void main(String[] args) 
	{
		
		Player player = new Player();
		Pattern melody = null;
		String cantus = "";

		generateMelody(SPECIES, 8);
		
		
		cantus = generateCantus(8);
		System.out.println(cantus);
		player.play(cantus);
	}
	
	
	
	private static void generateMelody(int species, int length)
	{
		String line = "";
		
		
		
		if( species == 1)
		{
			line += newSpecies1Note();
		}
		
	}



	private static String generateCantus(int length)
	{
		ArrayList<Integer> cantus = new ArrayList<Integer>();
		cantus.add(0);
		for(int i = 1; i < length; i++)
		{
				cantus.add(newCantusNote(cantus.get(i-1), length, i));
		}
		
		String cantusFormatted = "";
		for(int i = 0; i < cantus.size(); i++)
		{
			if(cantus.get(i) == 0)
				cantusFormatted += "Cw ";
			if(cantus.get(i) == 1)
				cantusFormatted += "C#w ";
			if(cantus.get(i) == 2)
				cantusFormatted += "Dw ";
			if(cantus.get(i) == 3)
				cantusFormatted += "D#w ";
			if(cantus.get(i) == 4)
				cantusFormatted += "Ew ";
			if(cantus.get(i) == 5)
				cantusFormatted += "Fw ";
			if(cantus.get(i) == 6)
				cantusFormatted += "Gw ";
			if(cantus.get(i) == 7)
				cantusFormatted += "G#w ";
			if(cantus.get(i) == 8)
				cantusFormatted += "Aw ";
			if(cantus.get(i) == 9)
				cantusFormatted += "A#w ";
			if(cantus.get(i) == 10)
				cantusFormatted += "Bw ";
			if(cantus.get(i) == 11)
				cantusFormatted += "C6w ";
		}
		cantusFormatted += "C";
		return cantusFormatted;
	}



	private static int newCantusNote(int lastNote, int length, int note)
	{
		ArrayList<Integer> notes = new ArrayList<Integer>();
		for(int i = 0; i < 12; i++)
			notes.add(i);
		
		/* Rules:
		 * 1. Only whole notes
		 * 2. No chromatic steps
		 * 3. no repeat
		 * 4. no augmented/diminished leaps, Intervals <= perfect 5th
		 * 5. Begin and end on tonic, precede with tone 2 or 7
		 * 6. All steps melodically consonant
		 * 7. 15% chance of leap, no consecutive leaps
		 * 8. Leading tone always moves to tonic
		 * 
		 */
		
		notes.remove((Integer)(lastNote-1));
		notes.remove((Integer)(lastNote+1));
		notes.remove((Integer)lastNote);
		if(lastNote >= 5 || lastNote <= 7)
		{
			for(int i = lastNote+7; i<12; i++)
				notes.remove((Integer)i);
			for(int i = lastNote-7; i>0; i++)
				notes.remove((Integer)i);
		}
		if (note == length - 1)
		{
			notes.clear();
			notes.add(2);
			notes.add(11);
		}
		if(note == 11)
		{
			notes.clear();
			notes.add(12);
		}
		Random random = new Random();
		int nextNote = notes.get(random.nextInt((notes.size())));
		
		return nextNote;
		
	}



	private static String newSpecies1Note()
	{
		ArrayList<Integer> notes = new ArrayList<Integer>();
		
		return "";
	}
}
