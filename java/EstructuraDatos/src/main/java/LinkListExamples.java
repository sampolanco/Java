import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkListExamples {

	private static <T> T findMiddleObject(LinkedList<T> linkList) {
		if(linkList==null)
			return null;
		Iterator<T> iteradorUnPaso=linkList.listIterator();
		Iterator<T> iteradorDosPasos=linkList.listIterator();
		
		T elementoMedio=null;
		while(iteradorDosPasos.hasNext()) {
			elementoMedio=iteradorUnPaso.next();
			iteradorDosPasos.next();
			if(!iteradorDosPasos.hasNext())
				return elementoMedio;
			iteradorDosPasos.next();
		}
		return elementoMedio;
	}
	
	private static <T> T reverse(LinkedList<T> linkList) {
		if(linkList==null)
			return null;
		Iterator<T> iteradorUnPaso=linkList.listIterator();
		Iterator<T> iteradorDosPasos=linkList.listIterator();
		
		T elementoMedio=null;
		while(iteradorDosPasos.hasNext()) {
			elementoMedio=iteradorUnPaso.next();
			iteradorDosPasos.next();
			if(!iteradorDosPasos.hasNext())
				return elementoMedio;
			iteradorDosPasos.next();
		}
		return elementoMedio;
	}
	
	public static void main(String[] args) {
		LinkedList<String> linkedList=new LinkedList<String>();
		linkedList.addAll(new LinkedList<String>(
				Arrays.asList(new String[]{"Samuel","Amadeus","Naomi","Ale","Servando"})
				));
		String objetoMedio=findMiddleObject(linkedList);
		System.out.println(objetoMedio);

	}

}
