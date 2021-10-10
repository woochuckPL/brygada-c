package pl.woochuck.brygadac.harmonogram;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import pl.woochuck.brygadac.R;

public class DayAdapter extends RecyclerView.Adapter<DayAdapter.ViewHolder> {

    private List<Day> days;

    public DayAdapter(List<Day> days) {
        this.days = days;
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        TextView cardTxtWeek = cardView.findViewById(R.id.cardTxtWeek);
        cardTxtWeek.setText(days.get(position).getWeek());
        TextView cardTxtMonth = cardView.findViewById(R.id.cardTxtMonth);
        cardTxtMonth.setText(days.get(position).getMonth());
        TextView cardTxtDate = cardView.findViewById(R.id.cardTxtDate);
        cardTxtDate.setText(Integer.toString(days.get(position).getDate()));
        TextView cardTxtDay = cardView.findViewById(R.id.cardTxtDay);
        cardTxtDay.setText(days.get(position).getDay());
        TextView cardTxtEmp0 = cardView.findViewById(R.id.cardTxtEmp0);
        cardTxtEmp0.setText(days.get(position).getShiftEmp0());
        TextView cardTxtEmp1 = cardView.findViewById(R.id.cardTxtEmp1);
        cardTxtEmp1.setText(days.get(position).getShiftEmp1());
        TextView cardTxtEmp2 = cardView.findViewById(R.id.cardTxtEmp2);
        cardTxtEmp2.setText(days.get(position).getShiftEmp2());
        TextView cardTxtEmp3 = cardView.findViewById(R.id.cardTxtEmp3);
        cardTxtEmp3.setText(days.get(position).getShiftEmp3());
        TextView cardTxtEmp4 = cardView.findViewById(R.id.cardTxtEmp4);
        cardTxtEmp4.setText(days.get(position).getShiftEmp4());
        TextView cardTxtEmp5 = cardView.findViewById(R.id.cardTxtEmp5);
        cardTxtEmp5.setText(days.get(position).getShiftEmp5());
        TextView cardTxtEmp6 = cardView.findViewById(R.id.cardTxtEmp6);
        cardTxtEmp6.setText(days.get(position).getShiftEmp6());
        TextView cardTxtEmp7 = cardView.findViewById(R.id.cardTxtEmp7);
        cardTxtEmp7.setText(days.get(position).getShiftEmp7());
        TextView cardTxtEmp8 = cardView.findViewById(R.id.cardTxtEmp8);
        cardTxtEmp8.setText(days.get(position).getShiftEmp8());
        TextView cardTxtEmp9 = cardView.findViewById(R.id.cardTxtEmp9);
        cardTxtEmp9.setText(days.get(position).getShiftEmp9());
        TextView cardTxtEmp10 = cardView.findViewById(R.id.cardTxtEmp10);
        cardTxtEmp10.setText(days.get(position).getShiftEmp10());
    }

    @Override
    public DayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_day, parent, false);
        return new ViewHolder(cardView);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(CardView cardView) {
            super(cardView);
            this.cardView = cardView;
        }
    }
}
