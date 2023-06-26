// import React,{useState} from 'react'
// import Button from "@mui/material/Button";
// import Dialog from "@mui/material/Dialog";
// import DialogActions from "@mui/material/DialogActions";
// import DialogContent from "@mui/material/DialogContent";
// import DialogTitle from "@mui/material/DialogTitle";
// import { makeStyles } from "@material-ui/core/styles";
// import TextField from "@mui/material/TextField";
// import Grid from "@mui/material/Grid";


// const useStyles = makeStyles((theme) => ({
//   dialogPaper: {
//     backgroundColor: "#2A3E4C !important",
//     color: "#FFFFFF !important",
//   },
//   txtBox: {
//     backgroundColor: "#FFFFFF !important",
//     borderRadius: "0.3rem !important",
//   },
// }));


// const AdvanceSearch = (props) => {
//     const classes = useStyles();
//     const [doc_id,set_doc_id] = useState("");
//     const [cust_order_id,set_cust_order_id] = useState("");
//     const [cust_num,set_cust_num] = useState("");
//     const [bus_year,set_bus_year] = useState("");

//     const [open, setOpen] = useState(false);

//     const handleSearch = () =>{
//       const advSearch_arr = [];
//       advSearch_arr.push(doc_id);
//       advSearch_arr.push(cust_order_id);
//       advSearch_arr.push(cust_num);
//       advSearch_arr.push(bus_year);
//       console.log(advSearch_arr);
//       props.adv_Search(advSearch_arr);
//       setOpen(false)
//     }

//     const handleClickOpen = () => {
//       setOpen(true);
//     };

//     const handleClose = () => {
//       setOpen(false);
//     };
//   return (
//     <>
//       <Button
//         variant="outlined"
//         style={{ color: "white", paddingLeft: "0.9rem", paddingRight: "0.9rem" }}
//         onClick={handleClickOpen}
//         size="medium"
//       >
//         Advance Search
//       </Button>
//       <Dialog
//         open={open}
//         onClose={handleClose}
//         classes={{ paper: classes.dialogPaper }}
//         aria-labelledby="form-dialog-title"
//       >
//         <DialogTitle>Advance Search</DialogTitle>
//         <DialogContent>
//           <form noValidate autoComplete="off">
//             <Grid container spacing={2}>
//               <Grid item md={6}>
//                 <TextField
//                   name="doc_id"
//                   variant="outlined"
//                   label="Document ID"
//                   onChange={(e) => set_doc_id(e.target.value)}
//                   className={classes.txtBox}
//                 />
//               </Grid>
//               <Grid item md={6}>
//                 <TextField
//                   name="cust_order_id"
//                   variant="outlined"
//                   label="Invoice ID"
//                   onChange={(e) => set_cust_order_id(e.target.value)}
//                   className={classes.txtBox}
//                 />
//               </Grid>
//               <Grid item md={6}>
//                 <TextField
//                   name="cust_num"
//                   variant="outlined"
//                   label="Customer Number"
//                   onChange={(e) => set_cust_num(e.target.value)}
//                   className={classes.txtBox}
//                 />
//               </Grid>
//               <Grid item md={6}>
//                 <TextField
//                   name="bus_year"
//                   variant="outlined"
//                   label="Business Year"
//                   onChange={(e) => set_bus_year(e.target.value)}
//                   className={classes.txtBox}
//                 />
//               </Grid>
//             </Grid>
//           </form>
//         </DialogContent>
//         <DialogActions>
//           <Button
//             onClick={handleSearch}
//             variant="outlined"
//             style={{ color: "white", borderColor: "white" }}
//           >
//             SEARCH
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

//  }

//  export default AdvanceSearch


import React, { useState } from 'react';
import Button from "@mui/material/Button";
import Dialog from "@mui/material/Dialog";
import DialogActions from "@mui/material/DialogActions";
import DialogContent from "@mui/material/DialogContent";
import DialogTitle from "@mui/material/DialogTitle";
import { makeStyles } from "@material-ui/core/styles";
import TextField from "@mui/material/TextField";
import Grid from "@mui/material/Grid";


const useStyles = makeStyles((theme) => ({
  dialogPaper: {
    backgroundColor: "#a9a9a9; !important",
    color: "#FFFFFF !important",
  },
  txtBox: {
    backgroundColor: "#fff !important",
    borderRadius: "0.3rem !important",
  },
}));


const AdvanceSearch = (props) => {
  const classes = useStyles();
  const [cust_order_id, set_cust_order_id] = useState("");
  const [cust_num, setcust_num] = useState("");
  //const [sales_org, setsalesorg] = useState("");
  const [open, setOpen] = useState(false);

  const handleSearch = () => {
    const advSearch_arr = [cust_order_id];
    console.log(advSearch_arr);
    props.adv_Search(advSearch_arr);
    setOpen(false);
  };

  const handleClickOpen = () => {
    setOpen(true);
    setcust_num("");
  };

  const handleClose = () => {
    setOpen(false);
  };

  return (
    <>
      <Button
        variant="outlined"
        style={{ color: "white", paddingLeft: "0.9rem", paddingRight: "0.9rem" }}
        onClick={handleClickOpen}
        size="medium"
      >
        Advance Search
      </Button>
      <Dialog
        open={open}
        onClose={handleClose}
        classes={{ paper: classes.dialogPaper }}
        aria-labelledby="form-dialog-title"
      >
        <DialogTitle>Advance Search</DialogTitle>
        <DialogContent>
          <form noValidate autoComplete="off">
            <Grid container spacing={2}>
              <Grid item md={6}>
                <TextField
                  name="cust_order_id"
                  variant="outlined"
                  label="CUSTOMER ORDER ID"
                  onChange={(e) => set_cust_order_id(e.target.value)}
                  className={classes.txtBox}  
                />
              </Grid>
              <Grid item md={6}>
                <TextField
                  name="cust_num"
                  variant="outlined"
                  label="CUSTOMER NUMBER"
                  onChange={(e) => setcust_num(e.target.value)}
                  className={classes.txtBox}
                />
              </Grid>
              <Grid item md={6}>
                <TextField
                  name="sales_org"
                  variant="outlined"
                  label="SALES ORG"
                  onChange={(e) => setcust_num(e.target.value)}
                  className={classes.txtBox}
                />
              </Grid>
            </Grid>
          </form>
        </DialogContent>
        <DialogActions>
          <Button
            onClick={handleSearch}
            variant="outlined"
            style={{ color: "white", borderColor: "white" }}
          >
            ADVANCED SEARCH
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

export default AdvanceSearch;
