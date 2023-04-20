
public class List {

	private Node head;
	
	private int size;
	
	
	public List () {
		head = null;
		size = 0;
		
	}
	
	public int Size () {
		return size;
	}
	
	private Node getNodePos ( int index ) throws IndexNotValidException {
		
		if ( index > this.size || index < 0 ) {
			throw new IndexNotValidException();
		}
		
		Node p = head;
		
		for (int i = 0 ; i < index ; i += 1 ) {
			p = p.getLink();
		}
		
		return p;
		
	}
	
	public void Add ( int index, Data input ) throws IndexNotValidException {
		
		if ( index == 0 ) { // inserimento in testa
			Add(input);
			size ++;
			return ;
		}
		
		Node tmp = new Node( new Data(input), getNodePos(index) );
		
		getNodePos(index-1).setLink(tmp);
		
		size ++;
		
	}
	
	public void Add ( Data input ) {
		
		Node tmp = new Node( new Data(input), head );

		head = tmp;
	
		size ++;
		
	}
	
	public void Remove ( int index ) throws IndexNotValidException, EmptyListException {
		
		if ( size == 0 )
			throw new EmptyListException();
		
		getNodePos(index-1).setLink(getNodePos(index+1));
		
		size --;
		
	}
	
	public Data getData( int index ) throws IndexNotValidException, EmptyListException {
		
		if ( size == 0 )
			throw new EmptyListException();
		
		return getNodePos(index).getInfo();
		
	}
	
	public void setData ( int index, Data input ) throws IndexNotValidException, EmptyListException {
		
		if ( size == 0 )
			throw new EmptyListException();
		
		getNodePos(index).setInfo(input);
		
	}
	
	
	
	
}
