
public class Node {

	private Data info;
	
	private Node link = null;
	
	public Node ( Data input, Node link ) {
		this.info = new Data(input);
		this.link = link;
		
	}
	
	public Node getLink () {
		return link;
	}
	
	public void setLink ( Node link ) {
		this.link = link;
	}
	
	public Data getInfo () {
		return new Data(this.info);
	}
	
	public void setInfo ( Data info ) {
		this.info = new Data(info);
	}
	
	
}
