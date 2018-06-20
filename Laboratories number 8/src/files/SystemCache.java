/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

/**
 *
 * @author Rafał
 */
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
public class SystemCache{

    public void setCache(HashMap<Parameter, Double> cache) {
        this.cache = cache;
    }
    
    HashMap<Parameter, Double> cache = new HashMap<>();
    public void put( double[] input, double output ){
        
        this.cache.put( new Parameter( input ), output );
    }

    public HashMap<Parameter, Double> getCache() {
        return cache;
    }
    public Double get( double[] input ){
        return this.cache.get( new Parameter( input ) );
    }
    public class Parameter implements Serializable{
        private double[] values;
        public Parameter( double[] values ){
            this.values = values;
        }
        @Override
        public int hashCode(){
            return 31 + Arrays.hashCode( this.values );
        }
        @Override
        public boolean equals( Object obj ){
            if ( this == obj )
                return true;
            if ( obj == null )
                return false;
            if ( this.getClass() != obj.getClass() )
                return false;
        Parameter other = (Parameter) obj;
        return Arrays.equals( this.values, other.values );
        }

        double[] getValues() {
            return values;
        }
    }
}

