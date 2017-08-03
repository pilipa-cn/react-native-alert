/**
 * Copyright (c) 2015-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */

package cn.pilipa.alert;

import javax.annotation.Nullable;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A fragment used to display the dialog.
 */
public class AlertFragment extends DialogFragment implements DialogInterface.OnClickListener {

  /* package */ static final String ARG_TITLE = "title";
  /* package */ static final String ARG_MESSAGE = "message";
  /* package */ static final String ARG_BUTTON_POSITIVE = "button_positive";
  /* package */ static final String ARG_BUTTON_NEGATIVE = "button_negative";
  /* package */ static final String ARG_BUTTON_NEUTRAL = "button_neutral";
  /* package */ static final String ARG_ITEMS = "items";

  private final @Nullable DialogModule.AlertFragmentListener mListener;

  public AlertFragment() {
      mListener = null;
  }

  public AlertFragment(@Nullable DialogModule.AlertFragmentListener listener, Bundle arguments) {
    mListener = listener;
    setArguments(arguments);
  }

  public static Dialog createDialog(Context activityContext, Bundle arguments, final DialogInterface.OnClickListener fragment) {

//     AlertDialog.Builder builder = new AlertDialog.Builder(activityContext)
//     .setTitle(arguments.getString(ARG_TITLE));
//
//
//    if (arguments.containsKey(ARG_BUTTON_POSITIVE)) {
//      builder.setPositiveButton(arguments.getString(ARG_BUTTON_POSITIVE), fragment);
//    }
//    if (arguments.containsKey(ARG_BUTTON_NEGATIVE)) {
//      builder.setNegativeButton(arguments.getString(ARG_BUTTON_NEGATIVE), fragment);
//    }
//    if (arguments.containsKey(ARG_BUTTON_NEUTRAL)) {
//      builder.setNeutralButton(arguments.getString(ARG_BUTTON_NEUTRAL), fragment);
//    }
//    // if both message and items are set, Android will only show the message
//    // and ignore the items argument entirely
//    if (arguments.containsKey(ARG_MESSAGE)) {
//      builder.setMessage(arguments.getString(ARG_MESSAGE));
//    }
//    if (arguments.containsKey(ARG_ITEMS)) {
//      builder.setItems(arguments.getCharSequenceArray(ARG_ITEMS), fragment);
//    }
//
//    return builder.create();


      Log.e("alertFragment","自定义弹窗");
    LayoutInflater layoutView = (LayoutInflater)activityContext.getSystemService(activityContext.LAYOUT_INFLATER_SERVICE);

    final Dialog dialog = new Dialog(activityContext,
            R.style.ios_dialog_style);
    View layout = layoutView.inflate(R.layout.ios_dialog, null);

    dialog.addContentView(layout, new ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

    ((TextView) layout.findViewById(R.id.title)).setText(arguments.getString(ARG_TITLE));
    ((TextView) layout.findViewById(R.id.title)).getPaint()
            .setFakeBoldText(true);
    if (arguments.getString(ARG_TITLE) == null || arguments.getString(ARG_TITLE).trim().length() == 0) {
      ((TextView) layout.findViewById(R.id.message))
              .setGravity(Gravity.CENTER);
    }

    if (arguments.getString(ARG_BUTTON_NEUTRAL) != null && arguments.getString(ARG_BUTTON_POSITIVE) != null
            && arguments.getString(ARG_BUTTON_NEGATIVE) != null) {
      ((Button) layout.findViewById(R.id.confirm_btn))
              .setText(arguments.getString(arguments.getString(ARG_BUTTON_POSITIVE)));
      if (fragment != null) {
        ((Button) layout.findViewById(R.id.neutral_btn))
                .setOnClickListener(new View.OnClickListener() {
                  public void onClick(View v) {
                    fragment.onClick(dialog,
                            DialogInterface.BUTTON_NEUTRAL);
                    dialog.dismiss();
                  }
                });
      } else {
        ((Button) layout.findViewById(R.id.neutral_btn))
                .setOnClickListener(new View.OnClickListener() {

                  @Override
                  public void onClick(View v) {
                    dialog.dismiss();
                  }
                });
      }
    } else {
      // if no confirm button or cancle button or neutral just set the
      // visibility to GONE
      layout.findViewById(R.id.neutral_btn).setVisibility(View.GONE);
      layout.findViewById(R.id.single_line).setVisibility(View.GONE);
    }
    // set the confirm button
    if (arguments.getString(ARG_BUTTON_POSITIVE) != null) {
      ((Button) layout.findViewById(R.id.confirm_btn))
              .setText(arguments.getString(ARG_BUTTON_POSITIVE));
      if (fragment != null) {
        ((Button) layout.findViewById(R.id.confirm_btn))
                .setOnClickListener(new View.OnClickListener() {
                  public void onClick(View v) {
                    fragment.onClick(dialog,
                            DialogInterface.BUTTON_POSITIVE);
                    dialog.dismiss();
                  }
                });
      } else {
        ((Button) layout.findViewById(R.id.confirm_btn))
                .setOnClickListener(new View.OnClickListener() {

                  @Override
                  public void onClick(View v) {
                    dialog.dismiss();
                  }
                });
      }
    } else {
      // if no confirm button just set the visibility to GONE
      layout.findViewById(R.id.confirm_btn).setVisibility(View.GONE);
      layout.findViewById(R.id.second_line).setVisibility(View.GONE);
      layout.findViewById(R.id.cancel_btn).setBackgroundResource(
              R.drawable.ios_single_btn_select);
    }
    // set the cancel button
    if (arguments.getString(ARG_BUTTON_NEGATIVE) != null) {
      ((Button) layout.findViewById(R.id.cancel_btn))
              .setText(arguments.getString(ARG_BUTTON_NEGATIVE));
      if (fragment != null) {
        ((Button) layout.findViewById(R.id.cancel_btn))
                .setOnClickListener(new View.OnClickListener() {
                  public void onClick(View v) {
                    fragment.onClick(dialog,
                            DialogInterface.BUTTON_NEGATIVE);
                    dialog.dismiss();
                  }
                });
      } else {
        ((Button) layout.findViewById(R.id.cancel_btn))
                .setOnClickListener(new View.OnClickListener() {

                  @Override
                  public void onClick(View v) {
                    dialog.dismiss();
                  }
                });
      }
    } else {
      // if no cancel button just set the visibility to GONE
      layout.findViewById(R.id.cancel_btn).setVisibility(View.GONE);
      layout.findViewById(R.id.second_line).setVisibility(View.GONE);
      layout.findViewById(R.id.confirm_btn).setBackgroundResource(
              R.drawable.ios_single_btn_select);
    }
    // set the content message
    if (arguments.getString(ARG_MESSAGE) != null) {
      ((TextView) layout.findViewById(R.id.message)).setText(arguments.getString(ARG_MESSAGE));
    }
    dialog.setContentView(layout);
    dialog.setCanceledOnTouchOutside(false);// 设置点击屏幕Dialog不消失

    return dialog;

  }

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    return createDialog(getActivity(), getArguments(), this);
  }

  @Override
  public void onClick(DialogInterface dialog, int which) {
    if (mListener != null) {
      mListener.onClick(dialog, which);
    }
  }

  @Override
  public void onDismiss(DialogInterface dialog) {
    super.onDismiss(dialog);
    if (mListener != null) {
      mListener.onDismiss(dialog);
    }
  }
}
