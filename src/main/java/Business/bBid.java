package Business;

import Helpers.DataConnection;
import Logging.Logging;
import Models.Bids;
import java.util.ArrayList;

public class bBid
{
    public boolean placeBid(Bids bid)
    {
        try (var db = new DataConnection())
        {
            return db.insertObject(bid.getClass(), bid);
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }
        return false;
    }

    public void changeBidStatus(int status, Bids bid)
    {
        if(bid == null || bid.getStatus() == status) return;

        try (var db = new DataConnection())
        {
            bid.setStatus(status);
            db.editObject(bid.getClass(), bid, bid.getId());
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }
    }

    public ArrayList<Bids> getBidsForListing(int listingId)
    {
        try (var db = new DataConnection())
        {
            return db.getListFromQuery(new Bids(), "SELECT b FROM Bids b JOIN Listings l ON b.listingId = l.Id WHERE l.Id = " + listingId);
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }

        return new ArrayList<>();
    }

    public ArrayList<Bids> getAllBids()
    {
        try(var db = new DataConnection())
        {
            return db.getListFromQuery(new Bids(), "SELECT bid FROM bids bid");
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
            return db.getObjectFromQuery(new Bids(), "SELECT bid FROM bids bid WHERE id = " + id);
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
            db.editObject(bid.getClass(), bid, bid.getId());
        }
        catch (Exception ex)
        {
            Logging.HandleError(ex);
        }
    }
}
