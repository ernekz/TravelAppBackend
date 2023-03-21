package com.swift.travelappbackend.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.swift.travelappbackend.model.TravelDestination;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class TravelDestinationService {

    private static final String COLLECTION_NAME = "travel_destination";

    public String saveTravelDestination(TravelDestination destination) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();

        ApiFuture<WriteResult> future = db.collection(COLLECTION_NAME).document().set(destination);

        return future.get().getUpdateTime().toString();
    }

    public TravelDestination getTravelDetails(String name) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference documentReference = db.collection(COLLECTION_NAME).document(name);

        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot documentSnapshot = future.get();

        TravelDestination destination = null;

        if(documentSnapshot.exists()){
            destination = documentSnapshot.toObject(TravelDestination.class);
            return destination;
        }
        else {
            return null;
        }
    }

    public List<TravelDestination> getTravels() throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();

        Iterable<DocumentReference> documentReferences = db.collection(COLLECTION_NAME).listDocuments();
        Iterator<DocumentReference> iterator = documentReferences.iterator();

        List<TravelDestination> travelDestinations = new ArrayList<>();
        TravelDestination travelDestination = null;

        while(iterator.hasNext()){
            DocumentReference documentReference1 = iterator.next();
            ApiFuture<DocumentSnapshot> future = documentReference1.get();
            DocumentSnapshot document = future.get();
            travelDestination = document.toObject(TravelDestination.class);
            travelDestinations.add(travelDestination);
        }

        return travelDestinations;
    }

    public String updateTravel(TravelDestination destination) throws ExecutionException, InterruptedException {
        Firestore db = FirestoreClient.getFirestore();

        ApiFuture<WriteResult> collectionApiFuture = db.collection(COLLECTION_NAME).document(destination.getCity()).set(destination);

        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public String deleteTravel(String name){
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = db.collection(COLLECTION_NAME).document(name).delete();
        return "Document with Travel country" + name + "has been deleted successfully";
    }


}
