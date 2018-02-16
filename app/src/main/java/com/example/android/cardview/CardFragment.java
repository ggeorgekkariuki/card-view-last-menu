package com.example.android.cardview;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CardFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardFragment extends Fragment {

    ArrayList<Bikes> listItems = new ArrayList<Bikes>();

    private RecyclerView MyRecyclerView;

    View.OnClickListener myOnClickListener;

    String CharacterNames [] = {"Steven Universe", "Amethyst","Connie", "Jasper",
            "Lars", "Pearl"};
    int Images [] = {
            R.drawable.steven_universe,
            R.drawable.amethyst,
            R.drawable.connie,
            R.drawable.jasper,
            R.drawable.lars,
            R.drawable.pearl
    };
    int id_ [] = {0, 1,2,3,4,5,6};
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CardFragment newInstance(String param1, String param2) {
        CardFragment fragment = new CardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialiseList();
        getActivity().setTitle("Steven Universe");


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    //Use the initializeList() method to initialize the ArrayList
    // in Android Cardview which will be passed to the Adapter later.
    private void initialiseList() {

        listItems.clear();

        for(int i = 0; i < CharacterNames.length; i++){
            Bikes items = new Bikes();
            items.setmName(CharacterNames[i]);
            items.setImageResourceId(Images[i]);
            items.setIsFav(0);
            items.setIsTurned(0);
            items.setId_(i);
            listItems.add(items);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card,container,false);
        MyRecyclerView = (RecyclerView) view.findViewById(R.id.cardView);
        MyRecyclerView.setHasFixedSize(true);
        //The purpose of the LayoutManager is to handle
        // the positioning of the list items and scrolling behaviour.
        LinearLayoutManager MyLayoutManager = new LinearLayoutManager(getActivity());
        MyLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        if(listItems.size() > 0 && MyRecyclerView != null){
            MyRecyclerView.setAdapter(new MyAdapter(listItems));
        }
        MyRecyclerView.setLayoutManager(MyLayoutManager);
        MyRecyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    //A view Holder is required to hold on to the views, so add the following code.
    public class MyViewHolder extends RecyclerView.ViewHolder{

        //The RecyclerView.ViewHolder class references the
        // ImageView and the TextViews for each view it will be holding.
        public CardView cardLayoutView;
        public LinearLayout linearLayoutView;
        public TextView characterTextView;
        public TextView viewTextView;
        public TextView titleTextView;
        public ImageView coverImageView;
        public ImageView likeImageView;
        public ImageView shareImageView;

        public MyViewHolder(View v) {
            super(v);
            //cardLayoutView = (CardView) v.findViewById(R.id.disappearingCardViewLayout);
            linearLayoutView = (LinearLayout) v.findViewById(R.id.disappearingLinearLayout);
            characterTextView = (TextView) v.findViewById(R.id.characterTitleTextView);
            viewTextView = (TextView) v.findViewById(R.id.viewMoreTextView);
            titleTextView = (TextView) v.findViewById(R.id.titleTextView);
            coverImageView = (ImageView) v.findViewById(R.id.coverImageView);
            likeImageView = (ImageView) v.findViewById(R.id.likeImageView);
            shareImageView = (ImageView) v.findViewById(R.id.shareImageView);

            viewTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(viewTextView.getText().toString().toLowerCase() == "view"){
                        viewTextView.setText("close");
                        linearLayoutView.setVisibility(View.VISIBLE);
                    } else{
                        viewTextView.setText("view");
                        linearLayoutView.setVisibility(View.GONE);
                    }
                }
            });

            likeImageView.setTag(R.drawable.ic_stars_black_18dp);
            likeImageView.setImageResource(R.drawable.ic_stars_black_18dp);
            Log.d("D: OutID", (String.valueOf((int) likeImageView.getTag())));

            likeImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //int like = 0;
                    int id = (int) likeImageView.getTag();
                    Log.d("D: drawableTag-White", (String.valueOf(R.drawable.ic_star_rate_white_18dp)));
                    Log.d("D: drawableTag-Black", (String.valueOf(R.drawable.ic_stars_black_18dp)));
                    Log.d("D: orgTagID", (String.valueOf(id)));
                    if( id == R.drawable.ic_stars_black_18dp)
                    {
                        likeImageView.setTag(R.drawable.ic_star_rate_white_18dp);
                        likeImageView.setImageResource(R.drawable.ic_star_rate_white_18dp);
                        Toast.makeText(getContext(),titleTextView.getText() +" liked",
                                Toast.LENGTH_SHORT).show();
                        //like = 1;

                    }else
                    {
                        likeImageView.setTag(R.drawable.ic_stars_black_18dp);
                        likeImageView.setImageResource(R.drawable.ic_stars_black_18dp);
                        Toast.makeText(getContext(),titleTextView.getText() +" disliked",
                                Toast.LENGTH_SHORT).show();
                        //like = 0;
                    }
                    Log.d("D: newTagID", (String.valueOf((int) likeImageView.getTag())));

                }
            });

            shareImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Uri imageUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                            "://" + getResources().getResourcePackageName(coverImageView.getId())
                            + '/' + "drawable" + '/' + getResources().getResourceEntryName((int)coverImageView.getTag()));
                    Intent shareIntent = new Intent();
                    shareIntent.setAction(Intent.ACTION_SEND);
                    shareIntent.putExtra(Intent.EXTRA_STREAM,imageUri);
                    shareIntent.setType("image/jpeg");
                    startActivity(Intent.createChooser(shareIntent,getResources().getText(R.string.send_to)));
                }
            });
            //Finally.
            //This is where a view can be clicked on.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getContext(), titleTextView.getText() + " clicked.",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), HomeActivity.class);
                    startActivity(intent);
                }
            });
        }

    }

    //this adapter is a link between the RecyclerView and the data which we want to list.
    // It creates required ViewHolders and also binds the ViewHolder to data from
    // the Bikes class.

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
        private int mIsEnabled = -1;
        private ArrayList<Bikes> list;
        public MyAdapter(ArrayList<Bikes> Data){
            list  = Data;
        }

        // Inflates the layout and creates a new view Holder.
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycle_items,parent,false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        //Binds the data to the view holder.
        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
            holder.characterTextView.setText(list.get(position).getmName());
            holder.titleTextView.setText(list.get(position).getmName());
            holder.coverImageView.setImageResource(list.get(position).getImageResourceId());
            holder.coverImageView.setTag(list.get(position).getImageResourceId());
            holder.likeImageView.setTag(R.drawable.ic_stars_black_18dp);
            holder.viewTextView.setText("view");

//            if(mIsEnabled == position){
//                holder.viewTextView.setText("Close");
//                holder.cardLayoutView.setVisibility(View.VISIBLE);
//            } else {
//                holder.viewTextView.setText("view");
//                holder.cardLayoutView.setVisibility(View.GONE);
//            }
            if(holder.viewTextView.getText().toString() == "view"){
                holder.linearLayoutView.setVisibility(View.GONE);
            }

        }

        // Returns the size of the data to be displayed.
        @Override
        public int getItemCount() {
            return list.size();
        }
    }

}
