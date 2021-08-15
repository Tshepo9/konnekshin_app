package com.example.ekse.Jobs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatDialogFragment
import com.example.splashscreen.R

class Createjob : AppCompatDialogFragment() {

    private var editName: EditText? = null
    private var editjobdesc: EditText? = null
    private var editSurname: EditText? = null
    private var editMessage: EditText? = null
    private var listener: CreateJobListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val inflater = requireActivity().layoutInflater
        val view: View = inflater.inflate(R.layout.activity_create_job, null)
        builder.setView(view)
            .setTitle("Create a job")
            .setNegativeButton(
                "cancel"
            ) { dialogInterface, i -> }
            .setPositiveButton(
                "ok"
            ) { dialogInterface, i ->
                val username = editName!!.text.toString()
                val job = editjobdesc!!.text.toString()
                val msg = editMessage!!.text.toString()
                val surname = editSurname!!.text.toString()
                listener!!.ApplyTexts(username, job, msg, surname)
            }
        editName = view.findViewById(R.id.editName)
        editjobdesc = view.findViewById(R.id.editjob)
        editSurname = view.findViewById(R.id.editSurname)
        editMessage = view.findViewById(R.id.editMessage)
        return builder.create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = try {
            context as CreateJobListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString() + "must implement CreateJobListener")
        }
    }

    interface CreateJobListener {
        fun ApplyTexts(username: String?, jb: String?, sname: String?, msg: String?)

    }
}