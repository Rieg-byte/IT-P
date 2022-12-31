import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ForkJoinWorkerThread;

/**
 * This class stores the basic state necessary for the A* algorithm to compute a
 * path across a map. This state includes a collection of "open waypoints" and
 * another collection of "closed waypoints." In addition, this class provides
 * the basic operations that the A* pathfinding algorithm needs to perform its
 * processing.
 **/
public class AStarState
{
    /** This is a reference to the map that the A* algorithm is navigating. **/
    private Map2D map;
    private HashMap<Location, Waypoint> openWaypoints = new HashMap<>();
    private HashMap<Location, Waypoint> closeWaypoints = new HashMap<>();

    /**
     * Initialize a new state object for the A* pathfinding algorithm to use.
     **/
    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    /** Returns the map that the A* pathfinder is navigating. **/
    public Map2D getMap()
    {
        return map;
    }

    /*
    Это функция проверяет все вершины в наборе открытых вершин, и
    после этого она должна вернуть ссылку на вершину с наименьшей
    общей стоимостью. Если в наборе нет вершин, то функция возвращает NULL
     */
    public Waypoint getMinOpenWaypoint() {
        if (openWaypoints.isEmpty()) {
            return null;
        } else {
            Waypoint minW = null;
            float min = Float.POSITIVE_INFINITY;
            for (Waypoint waypoint : openWaypoints.values()) {
                float cost = waypoint.getTotalCost();
                if (cost < min) {
                    min = cost;
                    minW = waypoint;
                }
            }
            return minW;
        }
    }


    /*
    Добавляет указанную вершину только в том случае, если существующая вершина хуже новой.
    Если в наборе открытых верщин нет вершины для данного местоположения, то добавляется новая
    Если в наборе есть вершина для этой локации, добавляется новая вершина только в том случае, если стоимость
    пути до новой вершины меньше стоимости пути до текущей
     */
    public boolean addOpenWaypoint(Waypoint newWaypoint) {
        Waypoint openWaypoint = openWaypoints.get(newWaypoint.loc);
        if (openWaypoint == null){
            openWaypoints.put(newWaypoint.loc, newWaypoint);
            return true;
        } else if(newWaypoint.getPreviousCost() < openWaypoint.getPreviousCost()){
            openWaypoints.put(newWaypoint.loc, newWaypoint);
            return true;
        } else return false;
    }


    /*
    Этот метод возвращает количество точек в наборе открытых вершин
     */
    public int numOpenWaypoints() {
        return openWaypoints.size();
    }


    /*
    Данный метод перемещает вершину из набора открытых вершин в набор закрытых вершин.
    Так как вершины обозначены местоположением, метод принимает местоположение вершины
     */
    public void closeWaypoint(Location location) {
        Waypoint waypoint = openWaypoints.remove(location);
        if (openWaypoints != null) {
            closeWaypoints.put(location, waypoint);
        }
    }

    /*
    Возвращает true, если указанное местоположение встречается в наборе закрытых вершин, и false в противном случае
     */
    public boolean isLocationClosed(Location loc) {
        return closeWaypoints.containsKey(loc);
    }
}

