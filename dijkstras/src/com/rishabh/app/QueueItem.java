package com.rishabh.app;



public class QueueItem implements Comparable<QueueItem>
{
	private String label;
	private String via;
	private int CumulativePathLength;
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public int getCumulativePathLength() {
		return CumulativePathLength;
	}
	public void setCumulativePathLength(int cumulativePathLength) {
		CumulativePathLength = cumulativePathLength;
	}
	
	@Override
	public int compareTo(QueueItem qi2) {
		if(this.getCumulativePathLength()<qi2.getCumulativePathLength())
			return -1;
		else if(this.getCumulativePathLength()==qi2.getCumulativePathLength())
			return 0;
		else if(this.getCumulativePathLength()>qi2.getCumulativePathLength())
			return 1;
		
		return 0;
	}
	
}
