package com.vasily.loftmoneyapp;

<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
<<<<<<< Updated upstream
=======
import android.util.Log;
>>>>>>> Stashed changes
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

<<<<<<< Updated upstream
import java.util.ArrayList;
import java.util.List;

=======
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

>>>>>>> Stashed changes

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemsFragment extends Fragment {

<<<<<<< Updated upstream
    private static final String KEY_TYPE = "type";

    private static final int TYPE_UNKNOWN = -1;

    public static final int TYPE_INCOMES = 1;
    public static final int TYPE_EXPENSES = 2;
    public static final int TYPE_BALANCE = 3;

    public static ItemsFragment newInstance(int type) {
        ItemsFragment fragment = new ItemsFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(ItemsFragment.KEY_TYPE, type);
=======
    private static final String TAG = "ItemsFragment";

    private static final String KEY_TYPE = "type";


    public static ItemsFragment newInstance(String type) {
        ItemsFragment fragment = new ItemsFragment();

        Bundle bundle = new Bundle();
        bundle.putString(ItemsFragment.KEY_TYPE, type);
>>>>>>> Stashed changes

        fragment.setArguments(bundle);

        return fragment;
    }


<<<<<<< Updated upstream
    public ItemsFragment() {}
=======
    public ItemsFragment() {
    }
>>>>>>> Stashed changes


    private RecyclerView recycler;
    private ItemsAdapter adapter;
<<<<<<< Updated upstream

    private int type;
=======
    private Api api;

    private String type;
>>>>>>> Stashed changes

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< Updated upstream

        Bundle args = getArguments();

        if (args != null) {
            type = args.getInt(KEY_TYPE, TYPE_UNKNOWN);

            if (type == TYPE_UNKNOWN) {
                throw new IllegalStateException("UNKNOWN TYPE");
            }
        } else {
            throw new IllegalStateException("YOU MAST PASS VALID FRAGMENT TYPE");
        }



        adapter = new ItemsAdapter();
        adapter.setItems(createTestItems());
=======
        Log.i(TAG, "onCreate: ");

        Bundle args = getArguments();
        type = args.getString(KEY_TYPE);

        api = ((App) getActivity().getApplication()).getApi();

        adapter = new ItemsAdapter();
        loadItems();
>>>>>>> Stashed changes
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
<<<<<<< Updated upstream
=======
        Log.i(TAG, "onCreateView: ");
>>>>>>> Stashed changes
        return inflater.inflate(R.layout.fragment_items, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
<<<<<<< Updated upstream
=======
        Log.i(TAG, "onViewCreated: ");
>>>>>>> Stashed changes
        recycler = view.findViewById(R.id.recycler);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

<<<<<<< Updated upstream
    private List<Item> createTestItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Молоко", "70р"));
        items.add(new Item("Зубная щетка", "70р"));
        items.add(new Item("Сковородка с антипригарным покрытием", "10000р"));
        items.add(new Item("Зубочистка", "2р"));
        items.add(new Item("Лошадь", "100000р"));
        items.add(new Item("Молоко", "70р"));
        items.add(new Item("Зубная щетка", "70р"));
        items.add(new Item("Сковородка с антипригарным покрытием", "10000р"));
        items.add(new Item("Зубочистка", "2р"));
        items.add(new Item("Лошадь", "100000р"));
        items.add(new Item("Молоко", "70р"));
        items.add(new Item("Зубная щетка", "70р"));
        items.add(new Item("Сковородка с антипригарным покрытием", "10000р"));
        items.add(new Item("Зубочистка", "2р"));
        items.add(new Item("Лошадь", "100000р"));
        items.add(new Item("Молоко", "70р"));
        items.add(new Item("Зубная щетка", "70р"));
        items.add(new Item("Сковородка с антипригарным покрытием", "10000р"));
        items.add(new Item("Зубочистка", "2р"));
        items.add(new Item("Лошадь", "100000р"));
        items.add(new Item("Молоко", "70р"));
        items.add(new Item("Зубная щетка", "70р"));
        items.add(new Item("Сковородка с антипригарным покрытием", "10000р"));
        items.add(new Item("Зубочистка", "2р"));
        items.add(new Item("Лошадь", "100000р"));
        items.add(new Item("Молоко", "70р"));
        items.add(new Item("Зубная щетка", "70р"));
        items.add(new Item("Сковородка с антипригарным покрытием", "10000р"));
        items.add(new Item("Зубочистка", "2р"));
        items.add(new Item("Лошадь", "100000р"));
        return items;
    }
}
=======
    @Override
    public void onDestroyView() {
        Log.i(TAG, "onDestroyView: ");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy: ");
        super.onDestroy();
    }

    private void loadItems() {

        Call call = api.getItems(type);

        call.enqueue(new Callback<List<Item>>() {

            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                List<Item> items = response.body();
                adapter.setItems(items);
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {

            }
        });

    }
}
>>>>>>> Stashed changes
