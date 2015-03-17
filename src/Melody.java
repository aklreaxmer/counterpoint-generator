import java.util.Random;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;
public class Melody extends Sequence 
{
	private int length, species, generation;
	private Track track;
	private Random random;
	public Melody(int length, int species, int generation) throws InvalidMidiDataException {
			
			super(Sequence.PPQ, species);
			this.generation = generation;
			random = new Random();
			track = this.createTrack();
			for(int i = 0; i < length; i++)
				track.add(generateNote(i));
	}
		

	private MidiEvent generateNote(int i)
	{
		//MIDI message data
		byte[] data = {
						(byte) 10010000, //Channel 1 Note ON
						(byte) 00000000, //Note Value Placeholder
						(byte) 01100100 //Velocity of 100
		};
		if(generation == 0) //Initial population - completely random notes
		{
			//generate a random byte 
			byte[] b = new byte[1];
			random.nextBytes(b);

			//add it to the data
			data[1] = b[0];
			
			return new MidiEvent(new MidiMessage(data), 1*i);
		return null;
		}
	
	}
}
