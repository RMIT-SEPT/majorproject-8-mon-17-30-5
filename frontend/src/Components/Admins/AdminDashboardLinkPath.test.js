import React from 'react';
import { configure, mount } from 'enzyme';
import { MemoryRouter } from 'react-router';
import BookingPage from './AdminDashboard';
import WorkerPage from './AdminDashboard';
import App from '../../App';
import ErrorPage from '../Layout/ErrorPage';
import Adapter from 'enzyme-adapter-react-16';

configure({ adapter: new Adapter() });

  test('invalid path should redirect to error page', () => {
    const wrapper = mount(
      <MemoryRouter initialEntries={[ '/' ]}>
        <App/>
      </MemoryRouter>
    );
    expect(wrapper.find(WorkerPage)).toHaveLength(0);
    expect(wrapper.find(BookingPage)).toHaveLength(0);
    expect(wrapper.find(ErrorPage)).toHaveLength(1);
  });

test('valid path for booking page', () => {
  const wrapper = mount(
    <MemoryRouter initialEntries={[ '/booking' ]}>
      <App/>
    </MemoryRouter>
  );
  expect(wrapper.find(BookingPage)).toHaveLength(1);
  expect(wrapper.find(ErrorPage)).toHaveLength(0);
});

test('valid path for worker page', () => {
    const wrapper = mount(
      <MemoryRouter initialEntries={[ '/admin/worker' ]}>
        <App/>
      </MemoryRouter>
    );
    expect(wrapper.find(WorkerPage)).toHaveLength(1);
    expect(wrapper.find(ErrorPage)).toHaveLength(0);
  });