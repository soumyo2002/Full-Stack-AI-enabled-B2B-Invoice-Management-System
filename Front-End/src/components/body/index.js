import React, { useState, useEffect } from "react";
import BodyHeader from "./bodyHeader";
import BodyFoot from "./bodyHeader/index1";
import { DataGrid } from "@mui/x-data-grid";
import axios from "axios";



const columns = [
  { field: 'Sl_no', headerName: 'SL No', width: 100},
  { field: 'CUSTOMER_ORDER_ID', headerName: 'CUSTOMER ORDER ID', width: 180},
  { field: 'SALES_ORG', headerName: 'SALES ORG', width: 150},
  { field: 'DISTRIBUTION_CHANNEL', headerName: 'DISTRIBUTION CHANNEL', width: 200},
  { field: 'COMPANY_CODE', headerName: 'COMPANY CODE', width: 150},
  { field: 'ORDER_CREATION_DATE', headerName: 'ORDER CREATION DATE', width: 200},
  { field: 'ORDER_CURRENCY', headerName: 'ORDER CURRENCY', width: 180},
  { field: 'CUSTOMER_NUMBER', headerName: 'CUSTOMER NUMBER', width: 180},
  { field: 'AMOUNT_IN_USD', headerName: 'Amount IN USD', type: 'number', width: 150},
  { field: 'ORDER_AMOUNT', headerName: 'ORDER AMOUNT', type: 'number', width: 150},
];

export const Body = () => {

  const [checkboxSelection, setCheckboxSelection] = useState(true);
  const [currentRow, setCurrentRow] = useState(false);
  const [pageSize, setPageSize] = useState();
  const [tableData, setTableData] = useState([]);
  const [searched, setSearched] = useState("");
  const [filteredData, setFilteredData] = useState([]);
  const [select, setSelection] = useState([]);
  const [adv_arr, setAdv_arr] = useState([]);

  // const adv_Search = (advSearch_arr) => {
  //   console.log(advSearch_arr);

  //   if (advSearch_arr.length !== 0) {
  //     const filteredRows = tableData.filter((row) => {
  //       return (
  //         row.buisness_year
  //           .toLowerCase()
  //           .includes(advSearch_arr[3].toLowerCase()) &&
  //         row.cust_number
  //           .toString()
  //           .toLowerCase()
  //           .includes(advSearch_arr[2].toLowerCase()) &&
  //         row.invoice_id
  //           .toString()
  //           .toLowerCase()
  //           .includes(advSearch_arr[1].toLowerCase()) &&
  //         row.doc_id.toLowerCase().includes(advSearch_arr[0].toLowerCase())
  //       );
  //     });
  //     setFilteredData(filteredRows);
  //     setAdv_arr(advSearch_arr);
  //   } else {
  //     setFilteredData(tableData);
  //   }
  // };
  const searchItems = (searchVal) => {
    setSearched(searchVal);
    if (searched !== "") {
      const filteredRows = tableData.filter((row) => {
        return (
          // row.Sl_no.toString().includes(searched) ||
          row.CUSTOMER_ORDER_ID
            .toString()
            .toLowerCase()
            .includes(searched.toLowerCase()) 
            // ||
          // row.CUSTOMER_NUMBER
          //   .toString()
          //   .toLowerCase()
          //   .includes(searched.toLowerCase())
        );
      });
      setFilteredData(filteredRows);
    } else {
      setFilteredData(tableData);
    }
  };
  

  const handleRowSelection = (e) => {
    setSelection(e);
    setCurrentRow(e.length > 0); // Update the currentRow state based on the length of the selection
  };
  

  

  useEffect(() => {
    axios
      .post("http://localhost:8080/h2h_milestone_3/getInvoice?start=0&limit=100000")
      .then((res) => {
        setTableData(res.data);
        console.log("begin:")
        console.log(tableData);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);
  return (
    <div style={{ backgroundColor: "#a9a9a9" }}>

      <BodyHeader
        currentRow={currentRow}
        searchItems={searchItems}
        select={select}
        // adv_Search={adv_Search}
        handleRowSelection={handleRowSelection}
      />

      <div style={{ height: 400, width: "100%" }}>
        {searched.length > 1 || adv_arr.length > 1 ? (
          <DataGrid
            getRowId={(r) => r.Sl_no}
            sx={{
              ".MuiDataGrid-columnSeparator": {
                display: "none",
              },
              ".MuiDataGrid-row:": {
                backgroundColor: "#a9a9a9",
              },
              ".MuiTablePagination-root, .MuiSvgIcon-root": {
                color: "#FFFFFF",
              },
              ".MuiTablePagination-selectLabel, .MuiTablePagination-displayedRows": {
                color: "#FFFFFF",
              },
              "& .MuiDataGrid-columnHeaderTitle": {
                overflow: "visible",
                lineHeight: "1.5rem",
                whiteSpace: "normal",
              },
              border: "none",
              color: "#FFFFFF",
              boxShadow: 5,
            }}
            rows={filteredData}
            columns={columns}
            pageSize={pageSize}
            onPageSizeChange={(newPageSize) => setPageSize(newPageSize)}
            rowsPerPageOptions={[8]}
            checkboxSelection={checkboxSelection}
            onSelectionModelChange={handleRowSelection}
            selectionModel={select}
            disableSelectionOnClick={true}
          />
        ): 
        (
          <DataGrid
          initialState={{
            pagination: { paginationModel: { pageSize: 8 } },
          }}
            getRowId={(r) => r.Sl_no}
            sx={{
              ".MuiDataGrid-columnSeparator": {
                display: "none",
              },
              ".MuiDataGrid-row:": {
                backgroundColor: '#a9a9a9'
              },
              ".MuiTablePagination-root, .MuiSvgIcon-root": {
                color: "#FFFFFF",
              },
              "& .MuiDataGrid-columnHeaderTitle": {
                overflow: "visible",
                lineHeight: "1.5rem",
                whiteSpace: "normal",
              },
              border: "none",
              color: "#FFFFFF",
              boxShadow: 5,
            }}
            rows={tableData}
            columns={columns}
            pageSize={8}
            onPageSizeChange={(newPageSize) => setPageSize(newPageSize)}
            pageSizeOptions={[8, 15, 25]}
            checkboxSelection={checkboxSelection}
            onSelectionModelChange={handleRowSelection}
            selectionModel={select}
            disableColumnFilter={true}
          />
        
        )}
        
      </div>

      <div class="MuiDataGrid-footerContainer MuiDataGrid">
      <BodyFoot
        currentRow={currentRow}
        searchItems={searchItems}
        select={select}
        // adv_Search={adv_Search}
        handleRowSelection={handleRowSelection}
        />
      </div>
      


    </div>
  );
};






