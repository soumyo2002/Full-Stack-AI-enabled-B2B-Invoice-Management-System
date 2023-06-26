// import React, { useState } from "react";
// import Button from "@mui/material/Button";
// import TextField from "@mui/material/TextField";
// import Grid from "@mui/material/Grid";
// import Dialog from "@mui/material/Dialog";
// import DialogActions from "@mui/material/DialogActions";
// import DialogContent from "@mui/material/DialogContent";
// import DialogTitle from "@mui/material/DialogTitle";
// import { makeStyles } from "@material-ui/core/styles";
// import axios from 'axios'

// const useStyles = makeStyles((theme) => ({
//   dialogPaper: {
//     backgroundColor: "#fff !important",
//     color: "#FFFFFF !important",
//   },
//   txtBox: {
//     backgroundColor: "#FFFFFF !important",
//     borderRadius: "0.3rem !important",
//   },
// }));

// const EditDialog = (props) => {
//   const classes = useStyles();

//   console.log(props.currentRow);
//   console.log(props.select);

//   const [ord_curr, set_ord_curr] = useState("");
//   const [comp_code, set_comp_code] = useState("");
//   //const [dist_channel, set_dist_channel] = useState("");
//   const [open, setOpen] = useState(false);

//   const handleClickOpen = () => {
//     setOpen(true);
//   };

//   const handleUpdate = (e) => {
//     if(props.select.length > 1){
//       alert("Multiple Row Selected");
//     }else{
//       e.preventDefault();

//       const url = `http://localhost:8080/h2h_milestone_3/EditInvoice?sl_no=${props.select[0]}&invoice_currency=${ord_curr}&cust_payment_terms=${comp_code}`;

//       try {
//         axios.get(url).then((res) => console.log(res.data));
//       } catch (err) {
//         console.log(err);
//       }
//     }
//     setOpen(false);
//   };

//   const handleClose = (e) => {
//     e.preventDefault();

//     console.log(ord_curr, comp_code);
//     setOpen(false);
//   };

//   return (
//     <>
//       <Button
//         variant="outlined"
//         style={{ color: "white", paddingLeft: "2rem", paddingRight: "2rem" }}
//         onClick={handleClickOpen}
//         disabled={!props.currentRow}
//         size="medium"
//       >
//         Edit
//       </Button>
//       <Dialog
//         open={open}
//         onClose={handleClose}
//         classes={{ paper: classes.dialogPaper }}
//         aria-labelledby="form-dialog-title"
//       >
//         <DialogTitle>EDIT</DialogTitle>
//         <DialogContent>
//           <form noValidate autoComplete="off">
//             <Grid container spacing={2}>
//               <Grid item md={6}>
//                 <TextField
//                   name="ord_curr"
//                   variant="outlined"
//                   label="Invoice Currency"
//                   onChange={(e) => set_ord_curr(e.target.value)}
//                   className={classes.txtBox}
//                 />
//               </Grid>
//               <Grid item md={6}>
//                 <TextField
//                   name="comp_code"
//                   variant="outlined"
//                   label="Customer Payment Terms"
//                   onChange={(e) => set_comp_code(e.target.value)}
//                   className={classes.txtBox}
//                 />
//               </Grid>
//             </Grid>
//           </form>
//         </DialogContent>
//         <DialogActions>
//           <Button
//             onClick={handleUpdate}
//             variant="outlined"
//             style={{ color: "white", borderColor: "white" }}
//           >
//             EDIT
//           </Button>
//           <Button
//             onClick={handleClose}
//             variant="outlined"
//             style={{ color: "white", borderColor: "white" }}
//           >
//             CANCEL
//           </Button>
//         </DialogActions>
//       </Dialog>
//     </>
//   );
// };

// export default EditDialog;




import React, { useState } from "react";
import Button from "@mui/material/Button";
import TextField from "@mui/material/TextField";
import Grid from "@mui/material/Grid";
import Dialog from "@mui/material/Dialog";
import DialogActions from "@mui/material/DialogActions";
import DialogContent from "@mui/material/DialogContent";
import DialogTitle from "@mui/material/DialogTitle";
import { makeStyles } from "@material-ui/core/styles";
import axios from 'axios'

const useStyles = makeStyles((theme) => ({
  dialogPaper: {
    backgroundColor: "#fff !important",
    color: "#FFFFFF !important",
  },
  txtBox: {
    backgroundColor: "#FFFFFF !important",
    borderRadius: "0.3rem !important",
  },
}));

const EditDialog = (props) => {
  const classes = useStyles();

  const [ord_curr, set_ord_curr] = useState("");
  const [comp_code, set_comp_code] = useState("");
  const [dist_channel, set_dist_channel] = useState("");
  const [open, setOpen] = useState(false);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleUpdate = (e) => {
    if (props.select.length > 1) {
      alert("Multiple Rows Selected");
    } else {
      e.preventDefault();
  
      const url = `http://localhost:8080/h2h_milestone_3/EditInvoice?Sl_no=${props.select[0]}&COMPANY_CODE=${comp_code}&ORDER_CURRENCY=${ord_curr}&DISTRIBUTION_CHANNEL=${dist_channel}`;
  
      try {
        axios.post(url)
          .then((res) => console.log(res.data))
          .catch((err) => console.log(err));
      } catch (err) {
        console.log(err);
      }
    }
  
    setOpen(false);
  };
  

  const handleClose = (e) => {
    e.preventDefault();

    setOpen(false);
  };

  return (
    <>
      <Button
        variant="outlined"
        style={{ color: "white", paddingLeft: "2rem", paddingRight: "2rem" }}
        onClick={handleClickOpen}
        disabled={!props.currentRow}
        size="medium"
      >
        Edit
      </Button>
      <Dialog
        open={open}
        onClose={handleClose}
        classes={{ paper: classes.dialogPaper }}
        aria-labelledby="form-dialog-title"
      >
        <DialogTitle>EDIT</DialogTitle>
        <DialogContent>
          <form noValidate autoComplete="off">
            <Grid container spacing={2}>
              <Grid item md={6}>
                <TextField
                  name="ord_curr"
                  variant="outlined"
                  label="Invoice Currency"
                  onChange={(e) => set_ord_curr(e.target.value)}
                  className={classes.txtBox}
                />
              </Grid>
              <Grid item md={6}>
                <TextField
                  name="comp_code"
                  variant="outlined"
                  label="Customer Payment Terms"
                  onChange={(e) => set_comp_code(e.target.value)}
                  className={classes.txtBox}
                />
              </Grid>
              <Grid item md={6}>
                <TextField
                  name="dist_channel"
                  variant="outlined"
                  label="distribution channel"
                  onChange={(e) => set_dist_channel(e.target.value)}
                  className={classes.txtBox}
                />
              </Grid>
            </Grid>
          </form>
        </DialogContent>
        <DialogActions>
          <Button
            onClick={handleUpdate}
            // onClick={handleClickOpen}
            variant="outlined"
            style={{ color: "white", borderColor: "white" }}
          >
            EDIT
          </Button>
          <Button
            onClick={handleClose}
            variant="outlined"
            style={{ color: "white", borderColor: "white" }}
          >
            CANCEL
          </Button>
        </DialogActions>
      </Dialog>
    </>
  );
};

export default EditDialog;
