import React, { useState } from "react";
import { Dialog } from "@material-ui/core";
import {
  Button,
  DialogActions,
  DialogContent,
  DialogTitle,
  Grid,
} from "@mui/material";
import TextField from "@mui/material/TextField";
import { makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles((theme) => ({
  dialogPaper: {
    maxWidth: "60rem !important",
    backgroundColor: "#2A3E4C !important",
    color: "#FFFFFF !important",
  },
  txtBox: {
    backgroundColor: "#FFFFFF !important",
    borderRadius: "0.3rem !important",
    width: "100% !important",
  },
}));

export const AnalyticsView = (props) => {
  const classes = useStyles();
  
  const [open, setOpen] = useState(false);
  const [dist_channel, set_dist_channel] = useState(new Date());
  const [cust_number, set_cust_number] = useState(new Date());
  const [curr, setCurr] = useState(new Date());


  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleSubmit = () => {
    console.log("Submit");
    //console.log(cl_date);
    handleClose();
  };
  return (
    <div>
      <Button
        variant="outlined"
        style={{ color: "white", paddingLeft: "1.2rem", paddingRight: "1.2rem" }}
        size="medium"
        onClick={handleClickOpen}
      >
        Analytics View
      </Button>

      <Dialog
        open={open}
        onClose={handleClose}
        classes={{ paper: classes.dialogPaper }}
        // aria-labelledby="form-dialog-title"
      >
        <DialogTitle>Analytics View</DialogTitle>
        <DialogContent>
          <form>
            <Grid container spacing={5}>
              <Grid item>
                {/* <p>DISTRIBUTION CHANNEL</p> */}
                <TextField
                  name="dist_channel"
                  variant="outlined"
                  //label="Clear Date"
                  size="small"
                  label = "DISTRIBUTION CHANNEL"
                  className={classes.txtBox}
                  onChange={(e) => set_dist_channel(e.target.value)}
                />
                <TextField
                  name="cust_number"
                  variant="outlined"
                  //label="Clear Date"
                  size="small"
                  label = "CUSTOMER NUMBER"
                  className={classes.txtBox}
                  onChange={(e) => set_cust_number(e.target.value)}
                />
              </Grid>
            </Grid>
          </form>
        </DialogContent>
        <DialogActions>
          <Button
            onClick={handleClose}
            variant="outlined"
            style={{ color: "white", borderColor: "white" }}
          >
            Cancel
          </Button>
          <Button
            onClick={handleSubmit}
            variant="outlined"
            style={{ color: "white", borderColor: "white" }}
          >
            Submit
          </Button>
        </DialogActions>
      </Dialog>
    </div>
  );
};
