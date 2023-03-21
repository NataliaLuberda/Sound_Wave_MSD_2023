public class Point {

	public Point nNeighbor;
	public Point wNeighbor;
	public Point eNeighbor;
	public Point sNeighbor;
	public float nVel;
	public float eVel;
	public float wVel;
	public float sVel;
	public float pressure;
	public int sinInput = 0;

	public static Integer []types ={0,1,2};
	int type;

	public Point() {
		clear();
		this.type = 0;
	}

	public void clicked() {
		pressure = 1;
	}
	
	public void clear() {
		// TODO: clear velocity and pressure
		this.nVel = 0;
		this.sVel = 0;
		this.eVel = 0;
		this.wVel = 0;

		this.pressure = 0;
	}

	public void updateVelocity() {
		// TODO: velocity update
		if(this.type == 0){
		this.nVel = this.nVel - (nNeighbor.pressure-this.pressure);
		
		this.sVel = this.sVel - (sNeighbor.pressure-this.pressure);
		
		this.eVel = this.eVel - (eNeighbor.pressure-this.pressure);

		this.wVel = this.wVel - (wNeighbor.pressure-this.pressure);
		};
	}

	public void updatePresure() {
		// TODO: pressure update
		sinInput += 3;
		float amplituda = 3;
		float frequency = 3;
		if(this.type == 0){
			this.pressure = (float) ((float)this.pressure - 0.5*(nVel+sVel+eVel+wVel));
		}else if(this.type == 2){
			double radians = Math.toRadians(sinInput);
			this.pressure = (float) ((float) amplituda*(Math.sin(2*Math.PI*frequency*radians)));
		};
	}


	public float getPressure() {
		return pressure;
	}
}