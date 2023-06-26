import React from "react";
//import AddDialog from "./addDialog";
import DeleteDialog from "./deleteDialog";
import EditDialog from "./editDialog";
import Button from "@mui/material/Button";
import { ButtonGroup } from "@material-ui/core";
//import AdvanceSearch from "./advanceSearch";
//import TextField from "@mui/material/TextField";
import "./style.css";
import { Predict } from "./predict";
//import RefreshIcon from "@material-ui/icons/Refresh";
//import { AnalyticsView } from "./analyticsView";

const bottom = (props) => {
  console.log('Values sire');
  console.log("props.currentRow = ",props.currentRow)
  console.log("props.select = ",props.select)

  return (
    <div className="parentBodyHeader">
    <Button 
        variant="outlined"
        onClick={() => window.location.reload(false)}
        className="refreshBtn"
        >
        REFRESH DATA
    </Button>
    <ButtonGroup>
        <EditDialog
          currentRow={props.currentRow}
          select={props.select}
        />
        <DeleteDialog currentRow={props.currentRow} select={props.select} />
        <Predict currentRow={props.currentRow} />
    </ButtonGroup>
    </div>
  );
};

export default bottom;
