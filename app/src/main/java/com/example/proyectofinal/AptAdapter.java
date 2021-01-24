package com.example.proyectofinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyectofinal.databinding.ApartmentListDataBinding;

import java.util.List;

//<>
public class AptAdapter extends RecyclerView.Adapter<AptAdapter.AptViewHolder>{
    private List<Apartment> mList;
    private IPasarElement mPass;

    public AptAdapter(List<Apartment> mList, IPasarElement mPass) {
        this.mList = mList;
        this.mPass = mPass;
    }

    @NonNull
    @Override
    public AptViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ApartmentListDataBinding mBinding = ApartmentListDataBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new AptViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AptViewHolder holder, int position) {
        Apartment element = mList.get(position);
        Glide.with(holder.ivDepto).load(element.getUrlImage()).centerCrop().into(holder.ivDepto);
        holder.tvNombre.setText(element.getNombre());
        holder.tvTorre.setText(element.getTorre());
        holder.tvDepto.setText(element.getDepto());
        holder.tvDireccion.setText(element.getDireccion());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class AptViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView ivDepto;
        private TextView tvNombre;
        private TextView tvTorre;
        private TextView tvDepto;
        private TextView tvDireccion;

        public AptViewHolder(@NonNull ApartmentListDataBinding mBinding) {

            super(mBinding.getRoot());
            ivDepto = mBinding.ivDepto;
            tvNombre = mBinding.tvNombre;
            tvTorre = mBinding.tvNombre;
            tvDepto = mBinding.tvDepto;
            tvDireccion = mBinding.tvDireccion;
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            Apartment item = mList.get(position);
            mPass.passElement(item);

        }
    }

    public interface IPasarElement {
        void passElement(Apartment item);
    }
}
