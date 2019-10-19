package Business;

import Helpers.DataConnection;
import Logging.Logging;
import Models.Bids;
import java.util.ArrayList;

public class bBid
{
    public boolean placeBid(Bids bid)
    {
        return false;
    }

    public void changeBidStatus(int status)
    {

    }

    public ArrayList<Bids> getBidsForListing(int listingId)
    {
        return new ArrayList<>();
    }

    public ArrayList<Bids> getAllBids()
    {
        try(var db = new DataConnection())
        {
            var bidsList = db.getListFromQuery(new Bids(), "SELECT bid FROM bids bid");
            return bidsList;
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }

        return new ArrayList<>();
    }

    public Bids getBid(int id)
    {
        try(var db = new DataConnection())
        {
            var bid = db.getObjectFromQuery(new Bids(), "SELECT bid FROM bids bid WHERE id = " + id);
            return bid;
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }

        return null;
    }

    public void editBid(Bids bid)
    {
        if(bid == null) return;

        try(var db = new DataConnection())
        {
            db.insertObject(bid.getClass(), bid);
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }
    }
}
