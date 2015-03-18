import javax.sound.midi.MidiMessage;


public class Message extends MidiMessage
{

	protected Message(byte[] data) {
		super(data);
	}

	
	
	public Object clone()
	{
		return null;
	}

}
